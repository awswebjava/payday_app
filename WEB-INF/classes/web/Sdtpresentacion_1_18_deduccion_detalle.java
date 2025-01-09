package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_deduccion_detalle extends GxUserType
{
   public Sdtpresentacion_1_18_deduccion_detalle( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_deduccion_detalle.class));
   }

   public Sdtpresentacion_1_18_deduccion_detalle( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_deduccion_detalle");
   }

   public Sdtpresentacion_1_18_deduccion_detalle( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_deduccion_detalle");
   }

   public Sdtpresentacion_1_18_deduccion_detalle( StructSdtpresentacion_1_18_deduccion_detalle struct )
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
      if ( oReader.existsAttribute("nombre") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre = oReader.getAttributeByName("nombre") ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
         }
      }
      if ( oReader.existsAttribute("valor") == 1 )
      {
         gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor = oReader.getAttributeByName("valor") ;
         readElement = true ;
         if ( GXSoapError > 0 )
         {
            readOk = (short)(1) ;
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
         sName = "presentacion_1_18.deduccion.detalle" ;
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
      oWriter.writeAttribute("nombre", gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre);
      oWriter.writeAttribute("valor", gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor);
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
      AddObjectProperty("nombre", gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre, false, false);
      AddObjectProperty("valor", gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor, false, false);
   }

   public String getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor ;
   }

   public void setgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor( String value )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre = "" ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_deduccion_detalle_N ;
   }

   public web.Sdtpresentacion_1_18_deduccion_detalle Clone( )
   {
      return (web.Sdtpresentacion_1_18_deduccion_detalle)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_deduccion_detalle struct )
   {
      setgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre(struct.getNombre());
      setgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor(struct.getValor());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_deduccion_detalle getStruct( )
   {
      web.StructSdtpresentacion_1_18_deduccion_detalle struct = new web.StructSdtpresentacion_1_18_deduccion_detalle ();
      struct.setNombre(getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre());
      struct.setValor(getgxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_deduccion_detalle_N ;
   protected short readOk ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_detalle_Nombre ;
   protected String gxTv_Sdtpresentacion_1_18_deduccion_detalle_Valor ;
   protected boolean readElement ;
   protected boolean formatError ;
}

