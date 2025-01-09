package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipotrabajo", "/web.tipotrabajo"})
public final  class tipotrabajo extends GXWebObjectStub
{
   public tipotrabajo( )
   {
   }

   public tipotrabajo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipotrabajo.class ));
   }

   public tipotrabajo( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipotrabajo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipotrabajo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Trabajo";
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

