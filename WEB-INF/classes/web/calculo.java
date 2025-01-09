package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.calculo", "/web.calculo"})
public final  class calculo extends GXWebObjectStub
{
   public calculo( )
   {
   }

   public calculo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( calculo.class ));
   }

   public calculo( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new calculo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new calculo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Calculo";
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

