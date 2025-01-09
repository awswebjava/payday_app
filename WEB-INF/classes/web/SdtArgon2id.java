package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtArgon2id extends GxUserType
{
   public SdtArgon2id( )
   {
      this(  new ModelContext(SdtArgon2id.class));
   }

   public SdtArgon2id( ModelContext context )
   {
      super( context, "SdtArgon2id");
   }

   public SdtArgon2id( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtArgon2id");
   }

   public SdtArgon2id( StructSdtArgon2id struct )
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

   public String generateargon2idminimal( String gxTp_param0 ,
                                          String gxTp_param1 )
   {
      String returngenerateargon2idminimal;
      if ( Argon2id_externalReference == null )
      {
         Argon2id_externalReference = new web.Argon2id() ;
      }
      returngenerateargon2idminimal = "";
      returngenerateargon2idminimal = Argon2id_externalReference.generateArgon2idMinimal(gxTp_param0, gxTp_param1) ;
      return returngenerateargon2idminimal ;
   }

   public String generateargon2idmoderate( String gxTp_param0 ,
                                           String gxTp_param1 )
   {
      String returngenerateargon2idmoderate;
      if ( Argon2id_externalReference == null )
      {
         Argon2id_externalReference = new web.Argon2id() ;
      }
      returngenerateargon2idmoderate = "";
      returngenerateargon2idmoderate = Argon2id_externalReference.generateArgon2idModerate(gxTp_param0, gxTp_param1) ;
      return returngenerateargon2idmoderate ;
   }

   public String generateargon2idsensitive( String gxTp_param0 ,
                                            String gxTp_param1 )
   {
      String returngenerateargon2idsensitive;
      if ( Argon2id_externalReference == null )
      {
         Argon2id_externalReference = new web.Argon2id() ;
      }
      returngenerateargon2idsensitive = "";
      returngenerateargon2idsensitive = Argon2id_externalReference.generateArgon2idSensitive(gxTp_param0, gxTp_param1) ;
      return returngenerateargon2idsensitive ;
   }

   public String generateargon2idinteractive( String gxTp_param0 ,
                                              String gxTp_param1 )
   {
      String returngenerateargon2idinteractive;
      if ( Argon2id_externalReference == null )
      {
         Argon2id_externalReference = new web.Argon2id() ;
      }
      returngenerateargon2idinteractive = "";
      returngenerateargon2idinteractive = Argon2id_externalReference.generateArgon2idInteractive(gxTp_param0, gxTp_param1) ;
      return returngenerateargon2idinteractive ;
   }

   public String generatesalt( )
   {
      String returngeneratesalt;
      if ( Argon2id_externalReference == null )
      {
         Argon2id_externalReference = new web.Argon2id() ;
      }
      returngeneratesalt = "";
      returngeneratesalt = Argon2id_externalReference.generateSalt() ;
      return returngeneratesalt ;
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

   public web.Argon2id getExternalInstance( )
   {
      if ( Argon2id_externalReference == null )
      {
         Argon2id_externalReference = new web.Argon2id() ;
      }
      return Argon2id_externalReference ;
   }

   public void setExternalInstance( web.Argon2id value )
   {
      Argon2id_externalReference = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
   }

   public web.SdtArgon2id Clone( )
   {
      return (web.SdtArgon2id)(clone()) ;
   }

   public void setStruct( web.StructSdtArgon2id struct )
   {
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtArgon2id getStruct( )
   {
      web.StructSdtArgon2id struct = new web.StructSdtArgon2id ();
      return struct ;
   }

   protected web.Argon2id Argon2id_externalReference=null ;
}

