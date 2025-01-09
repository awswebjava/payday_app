package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class rangofechassac extends GXProcedure
{
   public rangofechassac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( rangofechassac.class ), "" );
   }

   public rangofechassac( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( java.util.Date aP0 ,
                                     java.util.Date[] aP1 )
   {
      rangofechassac.this.aP2 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( java.util.Date aP0 ,
                        java.util.Date[] aP1 ,
                        java.util.Date[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( java.util.Date aP0 ,
                             java.util.Date[] aP1 ,
                             java.util.Date[] aP2 )
   {
      rangofechassac.this.AV8PeriodoLiquidado = aP0;
      rangofechassac.this.aP1 = aP1;
      rangofechassac.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.month( AV8PeriodoLiquidado) <= 6 )
      {
         AV9FecDesde = localUtil.ymdtod( GXutil.year( AV8PeriodoLiquidado), 1, 1) ;
      }
      else
      {
         AV9FecDesde = localUtil.ymdtod( GXutil.year( AV8PeriodoLiquidado), 7, 1) ;
      }
      AV10FecHasta = GXutil.eomdate( AV8PeriodoLiquidado) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = rangofechassac.this.AV9FecDesde;
      this.aP2[0] = rangofechassac.this.AV10FecHasta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9FecDesde = GXutil.nullDate() ;
      AV10FecHasta = GXutil.nullDate() ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private java.util.Date AV8PeriodoLiquidado ;
   private java.util.Date AV9FecDesde ;
   private java.util.Date AV10FecHasta ;
   private java.util.Date[] aP2 ;
   private java.util.Date[] aP1 ;
}

