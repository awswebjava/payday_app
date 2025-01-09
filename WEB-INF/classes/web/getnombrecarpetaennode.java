package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnombrecarpetaennode extends GXProcedure
{
   public getnombrecarpetaennode( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnombrecarpetaennode.class ), "" );
   }

   public getnombrecarpetaennode( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getnombrecarpetaennode.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getnombrecarpetaennode.this.AV9CliCod = aP0;
      getnombrecarpetaennode.this.AV10EmpCod = aP1;
      getnombrecarpetaennode.this.AV11LegNumero = aP2;
      getnombrecarpetaennode.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = httpContext.getMessage( "cliente_", "") + GXutil.trim( GXutil.str( AV9CliCod, 6, 0)) ;
      if ( ! (0==AV10EmpCod) )
      {
         AV8texto += httpContext.getMessage( "/empresa_", "") + GXutil.trim( GXutil.str( AV10EmpCod, 4, 0)) ;
         if ( ! (0==AV11LegNumero) )
         {
            AV8texto += httpContext.getMessage( "/legajo_", "") + GXutil.trim( GXutil.str( AV11LegNumero, 8, 0)) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getnombrecarpetaennode.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private String AV8texto ;
   private String[] aP3 ;
}

