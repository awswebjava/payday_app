package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTLugarPago_SDTLugarPagoItem extends GxUserType
{
   public SdtSDTLugarPago_SDTLugarPagoItem( )
   {
      this(  new ModelContext(SdtSDTLugarPago_SDTLugarPagoItem.class));
   }

   public SdtSDTLugarPago_SDTLugarPagoItem( ModelContext context )
   {
      super( context, "SdtSDTLugarPago_SDTLugarPagoItem");
   }

   public SdtSDTLugarPago_SDTLugarPagoItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTLugarPago_SDTLugarPagoItem");
   }

   public SdtSDTLugarPago_SDTLugarPagoItem( StructSdtSDTLugarPago_SDTLugarPagoItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LPGCodigo") )
            {
               gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LPGDescri") )
            {
               gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri = oReader.getValue() ;
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
         sName = "SDTLugarPago.SDTLugarPagoItem" ;
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
      oWriter.writeElement("LPGCodigo", gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LPGDescri", gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri);
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
      AddObjectProperty("LPGCodigo", gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo, false, false);
      AddObjectProperty("LPGDescri", gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri, false, false);
   }

   public String getgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo( )
   {
      return gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo ;
   }

   public void setgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo( String value )
   {
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N = (byte)(0) ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo = value ;
   }

   public String getgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri( )
   {
      return gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri ;
   }

   public void setgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri( String value )
   {
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N = (byte)(0) ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo = "" ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N = (byte)(1) ;
      gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N ;
   }

   public web.SdtSDTLugarPago_SDTLugarPagoItem Clone( )
   {
      return (web.SdtSDTLugarPago_SDTLugarPagoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtSDTLugarPago_SDTLugarPagoItem struct )
   {
      setgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo(struct.getLpgcodigo());
      setgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri(struct.getLpgdescri());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSDTLugarPago_SDTLugarPagoItem getStruct( )
   {
      web.StructSdtSDTLugarPago_SDTLugarPagoItem struct = new web.StructSdtSDTLugarPago_SDTLugarPagoItem ();
      struct.setLpgcodigo(getgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo());
      struct.setLpgdescri(getgxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri());
      return struct ;
   }

   protected byte gxTv_SdtSDTLugarPago_SDTLugarPagoItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgcodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTLugarPago_SDTLugarPagoItem_Lpgdescri ;
}

