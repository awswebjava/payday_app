package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mesesanio extends GXProcedure
{
   public mesesanio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mesesanio.class ), "" );
   }

   public mesesanio( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            java.util.Date aP3 )
   {
      mesesanio.this.aP4 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        short[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             short[] aP4 )
   {
      mesesanio.this.AV13CliCod = aP0;
      mesesanio.this.AV14EmpCod = aP1;
      mesesanio.this.AV10LegNumero = aP2;
      mesesanio.this.AV12LiqPeriodo = aP3;
      mesesanio.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV9primerMes ;
      GXv_int2[0] = GXt_int1 ;
      new web.primermestrabajado(remoteHandle, context).execute( AV13CliCod, AV14EmpCod, AV10LegNumero, AV12LiqPeriodo, GXv_int2) ;
      mesesanio.this.GXt_int1 = GXv_int2[0] ;
      AV9primerMes = GXt_int1 ;
      AV8mesesAnio = (short)(13-AV9primerMes) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = mesesanio.this.AV8mesesAnio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9primerMes ;
   private byte GXt_int1 ;
   private byte GXv_int2[] ;
   private short AV14EmpCod ;
   private short AV8mesesAnio ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private java.util.Date AV12LiqPeriodo ;
   private short[] aP4 ;
}

