package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paramww", "/web.paramww"})
public final  class paramww extends GXWebObjectStub
{
   public paramww( )
   {
   }

   public paramww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paramww.class ));
   }

   public paramww( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paramww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paramww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Valores Predeterminados";
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

