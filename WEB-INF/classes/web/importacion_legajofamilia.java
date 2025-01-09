package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importacion_legajofamilia", "/web.importacion_legajofamilia"})
public final  class importacion_legajofamilia extends GXWebObjectStub
{
   public importacion_legajofamilia( )
   {
   }

   public importacion_legajofamilia( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importacion_legajofamilia.class ));
   }

   public importacion_legajofamilia( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importacion_legajofamilia_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importacion_legajofamilia_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "importacion_legajo Familia";
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

