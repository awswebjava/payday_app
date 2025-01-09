package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_tipo_liqs_sdt_tipo_liqsItem extends GxUserType
{
   public Sdtsdt_tipo_liqs_sdt_tipo_liqsItem( )
   {
      this(  new ModelContext(Sdtsdt_tipo_liqs_sdt_tipo_liqsItem.class));
   }

   public Sdtsdt_tipo_liqs_sdt_tipo_liqsItem( ModelContext context )
   {
      super( context, "Sdtsdt_tipo_liqs_sdt_tipo_liqsItem");
   }

   public Sdtsdt_tipo_liqs_sdt_tipo_liqsItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_tipo_liqs_sdt_tipo_liqsItem");
   }

   public Sdtsdt_tipo_liqs_sdt_tipo_liqsItem( StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc") )
            {
               gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc = oReader.getValue() ;
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
         sName = "sdt_tipo_liqs.sdt_tipo_liqsItem" ;
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
      oWriter.writeElement("TLiqCod", gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TliqDesc", gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc);
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
      AddObjectProperty("TLiqCod", gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod, false, false);
      AddObjectProperty("TliqDesc", gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc, false, false);
   }

   public String getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod( )
   {
      return gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod ;
   }

   public void setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod( String value )
   {
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod = value ;
   }

   public String getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc( )
   {
      return gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc ;
   }

   public void setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc( String value )
   {
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod = "" ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N = (byte)(1) ;
      gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N ;
   }

   public web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem Clone( )
   {
      return (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem struct )
   {
      setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod(struct.getTliqcod());
      setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc(struct.getTliqdesc());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem getStruct( )
   {
      web.StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem struct = new web.StructSdtsdt_tipo_liqs_sdt_tipo_liqsItem ();
      struct.setTliqcod(getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod());
      struct.setTliqdesc(getgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc ;
}

