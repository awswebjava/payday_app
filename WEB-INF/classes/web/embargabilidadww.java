package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.embargabilidadww", "/web.embargabilidadww"})
public final  class embargabilidadww extends GXWebObjectStub
{
   public embargabilidadww( )
   {
   }

   public embargabilidadww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( embargabilidadww.class ));
   }

   public embargabilidadww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new embargabilidadww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new embargabilidadww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " embargabilidad";
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

