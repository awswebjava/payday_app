package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculafechavtosuelprecalc extends GXProcedure
{
   public calculafechavtosuelprecalc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculafechavtosuelprecalc.class ), "" );
   }

   public calculafechavtosuelprecalc( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     java.util.Date aP1 )
   {
      calculafechavtosuelprecalc.this.aP2 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        java.util.Date aP1 ,
                        java.util.Date[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             java.util.Date aP1 ,
                             java.util.Date[] aP2 )
   {
      calculafechavtosuelprecalc.this.AV9CliCod = aP0;
      calculafechavtosuelprecalc.this.AV10LegSuelFecha = aP1;
      calculafechavtosuelprecalc.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8maxImpOpeCliId = "[base_imp_max]" ;
      GXv_date1[0] = AV11LegSuelVto ;
      new web.varfechaproxactrelativa(remoteHandle, context).execute( AV9CliCod, AV8maxImpOpeCliId, AV10LegSuelFecha, GXv_date1) ;
      calculafechavtosuelprecalc.this.AV11LegSuelVto = GXv_date1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = calculafechavtosuelprecalc.this.AV11LegSuelVto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LegSuelVto = GXutil.nullDate() ;
      AV8maxImpOpeCliId = "" ;
      GXv_date1 = new java.util.Date[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8maxImpOpeCliId ;
   private java.util.Date AV10LegSuelFecha ;
   private java.util.Date AV11LegSuelVto ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date[] aP2 ;
}

