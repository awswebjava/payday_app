package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importarlegajofamilia", "/web.importarlegajofamilia"})
public final  class importarlegajofamilia extends GXWebObjectStub
{
   public importarlegajofamilia( )
   {
   }

   public importarlegajofamilia( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importarlegajofamilia.class ));
   }

   public importarlegajofamilia( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importarlegajofamilia_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importarlegajofamilia_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " importacion_legajo Familia";
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

