package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.categoria", "/web.categoria"})
public final  class categoria extends GXWebObjectStub
{
   public categoria( )
   {
   }

   public categoria( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( categoria.class ));
   }

   public categoria( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new categoria_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new categoria_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Categoria";
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
      return "categoria_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

