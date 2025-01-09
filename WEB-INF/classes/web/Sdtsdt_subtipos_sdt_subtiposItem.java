package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_subtipos_sdt_subtiposItem extends GxUserType
{
   public Sdtsdt_subtipos_sdt_subtiposItem( )
   {
      this(  new ModelContext(Sdtsdt_subtipos_sdt_subtiposItem.class));
   }

   public Sdtsdt_subtipos_sdt_subtiposItem( ModelContext context )
   {
      super( context, "Sdtsdt_subtipos_sdt_subtiposItem");
   }

   public Sdtsdt_subtipos_sdt_subtiposItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_subtipos_sdt_subtiposItem");
   }

   public Sdtsdt_subtipos_sdt_subtiposItem( StructSdtsdt_subtipos_sdt_subtiposItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod1") )
            {
               gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConDes1") )
            {
               gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 = oReader.getValue() ;
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
         sName = "sdt_subtipos.sdt_subtiposItem" ;
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
      oWriter.writeElement("SubTipoConCod1", gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SubTipoConDes1", gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1);
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
      AddObjectProperty("SubTipoConCod1", gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1, false, false);
      AddObjectProperty("SubTipoConDes1", gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1, false, false);
   }

   public String getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1( )
   {
      return gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 ;
   }

   public void setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1( String value )
   {
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N = (byte)(0) ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 = value ;
   }

   public String getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1( )
   {
      return gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 ;
   }

   public void setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1( String value )
   {
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N = (byte)(0) ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 = "" ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N = (byte)(1) ;
      gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N ;
   }

   public web.Sdtsdt_subtipos_sdt_subtiposItem Clone( )
   {
      return (web.Sdtsdt_subtipos_sdt_subtiposItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_subtipos_sdt_subtiposItem struct )
   {
      setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1(struct.getSubtipoconcod1());
      setgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1(struct.getSubtipocondes1());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_subtipos_sdt_subtiposItem getStruct( )
   {
      web.StructSdtsdt_subtipos_sdt_subtiposItem struct = new web.StructSdtsdt_subtipos_sdt_subtiposItem ();
      struct.setSubtipoconcod1(getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1());
      struct.setSubtipocondes1(getgxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_subtipos_sdt_subtiposItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipoconcod1 ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_subtipos_sdt_subtiposItem_Subtipocondes1 ;
}

