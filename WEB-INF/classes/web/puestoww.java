package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.puestoww", "/web.puestoww"})
public final  class puestoww extends GXWebObjectStub
{
   public puestoww( )
   {
   }

   public puestoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( puestoww.class ));
   }

   public puestoww( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new puestoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new puestoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Puesto";
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

