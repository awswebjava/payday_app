package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_dedEspInc_sdt_dedEspIncItem extends GxUserType
{
   public Sdtsdt_dedEspInc_sdt_dedEspIncItem( )
   {
      this(  new ModelContext(Sdtsdt_dedEspInc_sdt_dedEspIncItem.class));
   }

   public Sdtsdt_dedEspInc_sdt_dedEspIncItem( ModelContext context )
   {
      super( context, "Sdtsdt_dedEspInc_sdt_dedEspIncItem");
   }

   public Sdtsdt_dedEspInc_sdt_dedEspIncItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_dedEspInc_sdt_dedEspIncItem");
   }

   public Sdtsdt_dedEspInc_sdt_dedEspIncItem( StructSdtsdt_dedEspInc_sdt_dedEspIncItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "hasta") )
            {
               gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "deduccion") )
            {
               gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "sdt_dedEspInc.sdt_dedEspIncItem" ;
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
      oWriter.writeElement("hasta", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("deduccion", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("hasta", gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta, false, false);
      AddObjectProperty("deduccion", gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta( )
   {
      return gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta ;
   }

   public void setgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N = (byte)(0) ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion( )
   {
      return gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion ;
   }

   public void setgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N = (byte)(0) ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N = (byte)(1) ;
      gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N ;
   }

   public web.Sdtsdt_dedEspInc_sdt_dedEspIncItem Clone( )
   {
      return (web.Sdtsdt_dedEspInc_sdt_dedEspIncItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_dedEspInc_sdt_dedEspIncItem struct )
   {
      setgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta(struct.getHasta());
      setgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion(struct.getDeduccion());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_dedEspInc_sdt_dedEspIncItem getStruct( )
   {
      web.StructSdtsdt_dedEspInc_sdt_dedEspIncItem struct = new web.StructSdtsdt_dedEspInc_sdt_dedEspIncItem ();
      struct.setHasta(getgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta());
      struct.setDeduccion(getgxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Hasta ;
   protected java.math.BigDecimal gxTv_Sdtsdt_dedEspInc_sdt_dedEspIncItem_Deduccion ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

