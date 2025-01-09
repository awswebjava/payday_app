package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtZip extends GxUserType
{
   public SdtZip( )
   {
      this(  new ModelContext(SdtZip.class));
   }

   public SdtZip( ModelContext context )
   {
      super( context, "SdtZip");
   }

   public SdtZip( int remoteHandle ,
                  ModelContext context )
   {
      super( remoteHandle, context, "SdtZip");
   }

   public SdtZip( StructSdtZip struct )
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

   public int crear( String gxTp_RutaZip )
   {
      int returncrear;
      if ( Zip_externalReference == null )
      {
         Zip_externalReference = new com.paga.Zip() ;
      }
      returncrear = 0;
      returncrear = Zip_externalReference.crear(gxTp_RutaZip) ;
      return returncrear ;
   }

   public int agregararchivo( String gxTp_RutaArchivo ,
                              String gxTp_NombreEnZip )
   {
      int returnagregararchivo;
      if ( Zip_externalReference == null )
      {
         Zip_externalReference = new com.paga.Zip() ;
      }
      returnagregararchivo = 0;
      returnagregararchivo = Zip_externalReference.agregarArchivo(gxTp_RutaArchivo, gxTp_NombreEnZip) ;
      return returnagregararchivo ;
   }

   public int cerrar( )
   {
      int returncerrar;
      if ( Zip_externalReference == null )
      {
         Zip_externalReference = new com.paga.Zip() ;
      }
      returncerrar = 0;
      returncerrar = Zip_externalReference.cerrar() ;
      return returncerrar ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
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
   }

   public com.paga.Zip getExternalInstance( )
   {
      if ( Zip_externalReference == null )
      {
         Zip_externalReference = new com.paga.Zip() ;
      }
      return Zip_externalReference ;
   }

   public void setExternalInstance( com.paga.Zip value )
   {
      Zip_externalReference = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
   }

   public web.SdtZip Clone( )
   {
      return (web.SdtZip)(clone()) ;
   }

   public void setStruct( web.StructSdtZip struct )
   {
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtZip getStruct( )
   {
      web.StructSdtZip struct = new web.StructSdtZip ();
      return struct ;
   }

   protected com.paga.Zip Zip_externalReference=null ;
}

