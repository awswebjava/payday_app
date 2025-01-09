package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.feriadoww", "/web.feriadoww"})
public final  class feriadoww extends GXWebObjectStub
{
   public feriadoww( )
   {
   }

   public feriadoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( feriadoww.class ));
   }

   public feriadoww( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new feriadoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new feriadoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Feriados";
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

