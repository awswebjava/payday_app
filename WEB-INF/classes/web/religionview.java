package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.religionview", "/web.religionview"})
public final  class religionview extends GXWebObjectStub
{
   public religionview( )
   {
   }

   public religionview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( religionview.class ));
   }

   public religionview( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new religionview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new religionview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Religion View";
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

