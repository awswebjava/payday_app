package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisbase_calculo", "/web.paisbase_calculo"})
public final  class paisbase_calculo extends GXWebObjectStub
{
   public paisbase_calculo( )
   {
   }

   public paisbase_calculo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisbase_calculo.class ));
   }

   public paisbase_calculo( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisbase_calculo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisbase_calculo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Paisbase_calculo";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

