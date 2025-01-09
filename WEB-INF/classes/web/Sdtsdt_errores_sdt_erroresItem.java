package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_errores_sdt_erroresItem extends GxUserType
{
   public Sdtsdt_errores_sdt_erroresItem( )
   {
      this(  new ModelContext(Sdtsdt_errores_sdt_erroresItem.class));
   }

   public Sdtsdt_errores_sdt_erroresItem( ModelContext context )
   {
      super( context, "Sdtsdt_errores_sdt_erroresItem");
   }

   public Sdtsdt_errores_sdt_erroresItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_errores_sdt_erroresItem");
   }

   public Sdtsdt_errores_sdt_erroresItem( StructSdtsdt_errores_sdt_erroresItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "mensaje") )
            {
               gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje = oReader.getValue() ;
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
         sName = "sdt_errores.sdt_erroresItem" ;
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
      oWriter.writeElement("mensaje", gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje);
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
      AddObjectProperty("mensaje", gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje, false, false);
   }

   public String getgxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje( )
   {
      return gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje ;
   }

   public void setgxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje( String value )
   {
      gxTv_Sdtsdt_errores_sdt_erroresItem_N = (byte)(0) ;
      gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje = "" ;
      gxTv_Sdtsdt_errores_sdt_erroresItem_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_errores_sdt_erroresItem_N ;
   }

   public web.Sdtsdt_errores_sdt_erroresItem Clone( )
   {
      return (web.Sdtsdt_errores_sdt_erroresItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_errores_sdt_erroresItem struct )
   {
      setgxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje(struct.getMensaje());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_errores_sdt_erroresItem getStruct( )
   {
      web.StructSdtsdt_errores_sdt_erroresItem struct = new web.StructSdtsdt_errores_sdt_erroresItem ();
      struct.setMensaje(getgxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_errores_sdt_erroresItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_errores_sdt_erroresItem_Mensaje ;
}

