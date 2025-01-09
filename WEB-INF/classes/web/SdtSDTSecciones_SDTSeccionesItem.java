package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTSecciones_SDTSeccionesItem extends GxUserType
{
   public SdtSDTSecciones_SDTSeccionesItem( )
   {
      this(  new ModelContext(SdtSDTSecciones_SDTSeccionesItem.class));
   }

   public SdtSDTSecciones_SDTSeccionesItem( ModelContext context )
   {
      super( context, "SdtSDTSecciones_SDTSeccionesItem");
   }

   public SdtSDTSecciones_SDTSeccionesItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTSecciones_SDTSeccionesItem");
   }

   public SdtSDTSecciones_SDTSeccionesItem( StructSdtSDTSecciones_SDTSeccionesItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecCodigo") )
            {
               gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip") )
            {
               gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip = oReader.getValue() ;
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
         sName = "SDTSecciones.SDTSeccionesItem" ;
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
      oWriter.writeElement("SecCodigo", gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecDescrip", gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip);
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
      AddObjectProperty("SecCodigo", gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo, false, false);
      AddObjectProperty("SecDescrip", gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip, false, false);
   }

   public String getgxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo( )
   {
      return gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo ;
   }

   public void setgxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo( String value )
   {
      gxTv_SdtSDTSecciones_SDTSeccionesItem_N = (byte)(0) ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo = value ;
   }

   public String getgxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip( )
   {
      return gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip ;
   }

   public void setgxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip( String value )
   {
      gxTv_SdtSDTSecciones_SDTSeccionesItem_N = (byte)(0) ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo = "" ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_N = (byte)(1) ;
      gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTSecciones_SDTSeccionesItem_N ;
   }

   public web.SdtSDTSecciones_SDTSeccionesItem Clone( )
   {
      return (web.SdtSDTSecciones_SDTSeccionesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtSDTSecciones_SDTSeccionesItem struct )
   {
      setgxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo(struct.getSeccodigo());
      setgxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip(struct.getSecdescrip());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtSDTSecciones_SDTSeccionesItem getStruct( )
   {
      web.StructSdtSDTSecciones_SDTSeccionesItem struct = new web.StructSdtSDTSecciones_SDTSeccionesItem ();
      struct.setSeccodigo(getgxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo());
      struct.setSecdescrip(getgxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip());
      return struct ;
   }

   protected byte gxTv_SdtSDTSecciones_SDTSeccionesItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtSDTSecciones_SDTSeccionesItem_Seccodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTSecciones_SDTSeccionesItem_Secdescrip ;
}

