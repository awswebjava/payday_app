package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class daemonvalido extends GXProcedure
{
   public daemonvalido( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( daemonvalido.class ), "" );
   }

   public daemonvalido( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              boolean aP1 )
   {
      daemonvalido.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        boolean aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             boolean aP1 ,
                             boolean[] aP2 )
   {
      daemonvalido.this.AV8daemonUUID = aP0;
      daemonvalido.this.AV10updCount = aP1;
      daemonvalido.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV8daemonUUID)==0) && ( GXutil.strcmp(AV8daemonUUID, httpContext.getMessage( "LOCAL O HTTP", "")) != 0 ) && ( GXutil.strcmp(AV8daemonUUID, httpContext.getMessage( "LOCAL", "")) != 0 ) && ( GXutil.strcmp(AV8daemonUUID, httpContext.getMessage( "LAMBDA", "")) != 0 ) && ( GXutil.strcmp(AV8daemonUUID, httpContext.getMessage( "HTTP", "")) != 0 ) && ( GXutil.strSearch( AV8daemonUUID, httpContext.getMessage( "falló", ""), 1) == 0 ) )
      {
         AV9validoEs = true ;
      }
      if ( AV9validoEs )
      {
         if ( AV10updCount )
         {
            new web.upddaemoncount(remoteHandle, context).execute( 0, AV8daemonUUID) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( 0, AV13Pgmname, httpContext.getMessage( "&daemonid ", "")+GXutil.trim( AV8daemonUUID)+httpContext.getMessage( " valido ", "")+GXutil.trim( GXutil.booltostr( AV9validoEs))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = daemonvalido.this.AV9validoEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Pgmname = "" ;
      AV13Pgmname = "daemonValido" ;
      /* GeneXus formulas. */
      AV13Pgmname = "daemonValido" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8daemonUUID ;
   private String AV13Pgmname ;
   private boolean AV10updCount ;
   private boolean AV9validoEs ;
   private boolean[] aP2 ;
}

