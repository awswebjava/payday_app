package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTLegajos_SDTLegajosItem extends GxUserType
{
   public SdtSDTLegajos_SDTLegajosItem( )
   {
      this(  new ModelContext(SdtSDTLegajos_SDTLegajosItem.class));
   }

   public SdtSDTLegajos_SDTLegajosItem( ModelContext context )
   {
      super( context, "SdtSDTLegajos_SDTLegajosItem");
   }

   public SdtSDTLegajos_SDTLegajosItem( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTLegajos_SDTLegajosItem");
   }

   public SdtSDTLegajos_SDTLegajosItem( StructSdtSDTLegajos_SDTLegajosItem struct )
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
               gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegId") )
            {
               gxTv_SdtSDTLegajos_SDTLegajosItem_Legid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegApellido") )
            {
               gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNombre") )
            {
               gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegIdNomApe") )
            {
               gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "seleccionado") )
            {
               gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AgeCanti") )
            {
               gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "SDTLegajos.SDTLegajosItem" ;
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
      oWriter.writeElement("LegNumero", GXutil.trim( GXutil.str( gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegId", gxTv_SdtSDTLegajos_SDTLegajosItem_Legid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegApellido", gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNombre", gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegIdNomApe", gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("seleccionado", GXutil.booltostr( gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AgeCanti", GXutil.trim( GXutil.strNoRound( gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti, 9, 2)));
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
      AddObjectProperty("LegNumero", gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero, false, false);
      AddObjectProperty("LegId", gxTv_SdtSDTLegajos_SDTLegajosItem_Legid, false, false);
      AddObjectProperty("LegApellido", gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido, false, false);
      AddObjectProperty("LegNombre", gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre, false, false);
      AddObjectProperty("LegIdNomApe", gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape, false, false);
      AddObjectProperty("seleccionado", gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado, false, false);
      AddObjectProperty("AgeCanti", gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti, false, false);
   }

   public int getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero( int value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero = value ;
   }

   public String getgxTv_SdtSDTLegajos_SDTLegajosItem_Legid( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legid ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Legid( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legid = value ;
   }

   public String getgxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido = value ;
   }

   public String getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre = value ;
   }

   public String getgxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape( String value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape = value ;
   }

   public boolean getgxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado( boolean value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado = value ;
   }

   public java.math.BigDecimal getgxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti ;
   }

   public void setgxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti( java.math.BigDecimal value )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(0) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTLegajos_SDTLegajosItem_N = (byte)(1) ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legid = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape = "" ;
      gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTLegajos_SDTLegajosItem_N ;
   }

   public web.SdtSDTLegajos_SDTLegajosItem Clone( )
   {
      return (web.SdtSDTLegajos_SDTLegajosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtSDTLegajos_SDTLegajosItem struct )
   {
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero(struct.getLegnumero());
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Legid(struct.getLegid());
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido(struct.getLegapellido());
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre(struct.getLegnombre());
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape(struct.getLegidnomape());
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado(struct.getSeleccionado());
      setgxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti(struct.getAgecanti());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSDTLegajos_SDTLegajosItem getStruct( )
   {
      web.StructSdtSDTLegajos_SDTLegajosItem struct = new web.StructSdtSDTLegajos_SDTLegajosItem ();
      struct.setLegnumero(getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero());
      struct.setLegid(getgxTv_SdtSDTLegajos_SDTLegajosItem_Legid());
      struct.setLegapellido(getgxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido());
      struct.setLegnombre(getgxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre());
      struct.setLegidnomape(getgxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape());
      struct.setSeleccionado(getgxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado());
      struct.setAgecanti(getgxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti());
      return struct ;
   }

   protected byte gxTv_SdtSDTLegajos_SDTLegajosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtSDTLegajos_SDTLegajosItem_Legnumero ;
   protected java.math.BigDecimal gxTv_SdtSDTLegajos_SDTLegajosItem_Agecanti ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legid ;
   protected String sTagName ;
   protected boolean gxTv_SdtSDTLegajos_SDTLegajosItem_Seleccionado ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legapellido ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legnombre ;
   protected String gxTv_SdtSDTLegajos_SDTLegajosItem_Legidnomape ;
}

