package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLambdaInvoker extends GxUserType
{
   public SdtLambdaInvoker( )
   {
      this(  new ModelContext(SdtLambdaInvoker.class));
   }

   public SdtLambdaInvoker( ModelContext context )
   {
      super( context, "SdtLambdaInvoker");
   }

   public SdtLambdaInvoker( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtLambdaInvoker");
   }

   public SdtLambdaInvoker( StructSdtLambdaInvoker struct )
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

   public String handlerequest( String gxTp_functionName ,
                                String gxTp_invocationType ,
                                String gxTp_jsonPayload )
   {
      String returnhandlerequest;
      if ( LambdaInvoker_externalReference == null )
      {
         LambdaInvoker_externalReference = new web.LambdaInvoker() ;
      }
      returnhandlerequest = "";
      returnhandlerequest = LambdaInvoker_externalReference.handleRequest(gxTp_functionName, gxTp_invocationType, gxTp_jsonPayload) ;
      return returnhandlerequest ;
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

   public web.LambdaInvoker getExternalInstance( )
   {
      if ( LambdaInvoker_externalReference == null )
      {
         LambdaInvoker_externalReference = new web.LambdaInvoker() ;
      }
      return LambdaInvoker_externalReference ;
   }

   public void setExternalInstance( web.LambdaInvoker value )
   {
      LambdaInvoker_externalReference = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
   }

   public web.SdtLambdaInvoker Clone( )
   {
      return (web.SdtLambdaInvoker)(clone()) ;
   }

   public void setStruct( web.StructSdtLambdaInvoker struct )
   {
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLambdaInvoker getStruct( )
   {
      web.StructSdtLambdaInvoker struct = new web.StructSdtLambdaInvoker ();
      return struct ;
   }

   protected web.LambdaInvoker LambdaInvoker_externalReference=null ;
}

