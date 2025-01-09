package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_leg_aux_sdt_leg_auxItem extends GxUserType
{
   public Sdtsdt_leg_aux_sdt_leg_auxItem( )
   {
      this(  new ModelContext(Sdtsdt_leg_aux_sdt_leg_auxItem.class));
   }

   public Sdtsdt_leg_aux_sdt_leg_auxItem( ModelContext context )
   {
      super( context, "Sdtsdt_leg_aux_sdt_leg_auxItem");
   }

   public Sdtsdt_leg_aux_sdt_leg_auxItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_leg_aux_sdt_leg_auxItem");
   }

   public Sdtsdt_leg_aux_sdt_leg_auxItem( StructSdtsdt_leg_aux_sdt_leg_auxItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero") )
            {
               gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegAuxEstado") )
            {
               gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegErrorAux") )
            {
               gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpContr") )
            {
               gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdt_leg_aux.sdt_leg_auxItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegAuxEstado", GXutil.trim( GXutil.str( gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegErrorAux", gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpContr", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("LegNumero", gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero, false, false);
      AddObjectProperty("LiqLegAuxEstado", gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado, false, false);
      AddObjectProperty("LiqLegErrorAux", gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux, false, false);
      AddObjectProperty("LiqLegImpContr", gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr, false, false);
   }

   public int getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero ;
   }

   public void setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero( int value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero = value ;
   }

   public byte getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado ;
   }

   public void setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado( byte value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado = value ;
   }

   public String getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux ;
   }

   public void setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux( String value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr ;
   }

   public void setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(0) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N = (byte)(1) ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux = "" ;
      gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N ;
   }

   public web.Sdtsdt_leg_aux_sdt_leg_auxItem Clone( )
   {
      return (web.Sdtsdt_leg_aux_sdt_leg_auxItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_leg_aux_sdt_leg_auxItem struct )
   {
      setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero(struct.getLegnumero());
      setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado(struct.getLiqlegauxestado());
      setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux(struct.getLiqlegerroraux());
      setgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr(struct.getLiqlegimpcontr());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_leg_aux_sdt_leg_auxItem getStruct( )
   {
      web.StructSdtsdt_leg_aux_sdt_leg_auxItem struct = new web.StructSdtsdt_leg_aux_sdt_leg_auxItem ();
      struct.setLegnumero(getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero());
      struct.setLiqlegauxestado(getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado());
      struct.setLiqlegerroraux(getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux());
      struct.setLiqlegimpcontr(getgxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_N ;
   protected byte gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegauxestado ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Legnumero ;
   protected java.math.BigDecimal gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegimpcontr ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_leg_aux_sdt_leg_auxItem_Liqlegerroraux ;
}

