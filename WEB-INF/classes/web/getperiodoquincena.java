package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoquincena extends GXProcedure
{
   public getperiodoquincena( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoquincena.class ), "" );
   }

   public getperiodoquincena( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     java.util.Date aP2 ,
                                     java.util.Date[] aP3 )
   {
      getperiodoquincena.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 ,
                             java.util.Date[] aP4 )
   {
      getperiodoquincena.this.AV12CliCod = aP0;
      getperiodoquincena.this.AV8quincena = aP1;
      getperiodoquincena.this.AV10LiqPeriodo = aP2;
      getperiodoquincena.this.aP3 = aP3;
      getperiodoquincena.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8quincena == 1 )
      {
         AV9diaDate = AV10LiqPeriodo ;
         AV11finDate = localUtil.ymdtod( GXutil.year( AV10LiqPeriodo), GXutil.month( AV10LiqPeriodo), 15) ;
      }
      else
      {
         AV9diaDate = localUtil.ymdtod( GXutil.year( AV10LiqPeriodo), GXutil.month( AV10LiqPeriodo), 16) ;
         AV11finDate = GXutil.eomdate( AV10LiqPeriodo) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiodoquincena.this.AV9diaDate;
      this.aP4[0] = getperiodoquincena.this.AV11finDate;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9diaDate = GXutil.nullDate() ;
      AV11finDate = GXutil.nullDate() ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8quincena ;
   private short Gx_err ;
   private int AV12CliCod ;
   private java.util.Date AV10LiqPeriodo ;
   private java.util.Date AV9diaDate ;
   private java.util.Date AV11finDate ;
   private java.util.Date[] aP4 ;
   private java.util.Date[] aP3 ;
}

