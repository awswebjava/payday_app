package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_legajomigrlegupd", "/web.importacion_legajomigrlegupd"})
public final  class importacion_legajomigrlegupd extends GXWebObjectStub
{
   public importacion_legajomigrlegupd( )
   {
   }

   public importacion_legajomigrlegupd( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_legajomigrlegupd.class ));
   }

   public importacion_legajomigrlegupd( int remoteHandle ,
                                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_legajomigrlegupd_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_legajomigrlegupd_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_legajo Migr Leg UPD";
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

