package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.reinicializardatos", "/web.reinicializardatos"})
public final  class reinicializardatos extends GXWebObjectStub
{
   public reinicializardatos( )
   {
   }

   public reinicializardatos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( reinicializardatos.class ));
   }

   public reinicializardatos( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new reinicializardatos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new reinicializardatos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Reinicializar Datos";
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

