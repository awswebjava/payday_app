package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.bienvenidalegajo", "/web.bienvenidalegajo"})
public final  class bienvenidalegajo extends GXWebObjectStub
{
   public bienvenidalegajo( )
   {
   }

   public bienvenidalegajo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( bienvenidalegajo.class ));
   }

   public bienvenidalegajo( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new bienvenidalegajo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new bienvenidalegajo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Bienvenida Legajo";
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

