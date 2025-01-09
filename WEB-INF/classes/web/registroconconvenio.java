package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.registroconconvenio", "/web.registroconconvenio"})
public final  class registroconconvenio extends GXWebObjectStub
{
   public registroconconvenio( )
   {
   }

   public registroconconvenio( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( registroconconvenio.class ));
   }

   public registroconconvenio( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new registroconconvenio_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new registroconconvenio_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Registro Con Convenio";
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

