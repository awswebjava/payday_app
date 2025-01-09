package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clienteconveniosww", "/web.clienteconveniosww"})
public final  class clienteconveniosww extends GXWebObjectStub
{
   public clienteconveniosww( )
   {
   }

   public clienteconveniosww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clienteconveniosww.class ));
   }

   public clienteconveniosww( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clienteconveniosww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clienteconveniosww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Convenios";
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

