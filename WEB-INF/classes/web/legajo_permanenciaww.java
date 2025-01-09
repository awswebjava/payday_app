package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajo_permanenciaww", "/web.legajo_permanenciaww"})
public final  class legajo_permanenciaww extends GXWebObjectStub
{
   public legajo_permanenciaww( )
   {
   }

   public legajo_permanenciaww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajo_permanenciaww.class ));
   }

   public legajo_permanenciaww( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajo_permanenciaww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajo_permanenciaww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " legajo_permanencia";
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

