package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodosigliq extends GXProcedure
{
   public getperiodosigliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodosigliq.class ), "" );
   }

   public getperiodosigliq( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short[] aP3 ,
                              short[] aP4 )
   {
      getperiodosigliq.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 ,
                        short[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 ,
                             short[] aP4 ,
                             boolean[] aP5 )
   {
      getperiodosigliq.this.AV12CliCod = aP0;
      getperiodosigliq.this.AV13EmpCod = aP1;
      getperiodosigliq.this.AV14LegNumero = aP2;
      getperiodosigliq.this.aP3 = aP3;
      getperiodosigliq.this.aP4 = aP4;
      getperiodosigliq.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV8anio ;
      GXv_int2[0] = AV10MesNro ;
      GXv_boolean3[0] = AV15hay ;
      new web.getperiodoultliqmensual(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV14LegNumero, GXv_int1, GXv_int2, GXv_boolean3) ;
      getperiodosigliq.this.AV8anio = GXv_int1[0] ;
      getperiodosigliq.this.AV10MesNro = GXv_int2[0] ;
      getperiodosigliq.this.AV15hay = GXv_boolean3[0] ;
      GXv_int2[0] = AV10MesNro ;
      GXv_int1[0] = AV8anio ;
      new web.getperiodosiguiente(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, GXv_int2, GXv_int1) ;
      getperiodosigliq.this.AV10MesNro = GXv_int2[0] ;
      getperiodosigliq.this.AV8anio = GXv_int1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiodosigliq.this.AV8anio;
      this.aP4[0] = getperiodosigliq.this.AV10MesNro;
      this.aP5[0] = getperiodosigliq.this.AV15hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_boolean3 = new boolean[1] ;
      GXv_int2 = new short[1] ;
      GXv_int1 = new short[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV8anio ;
   private short AV10MesNro ;
   private short GXv_int2[] ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV14LegNumero ;
   private boolean AV15hay ;
   private boolean GXv_boolean3[] ;
   private boolean[] aP5 ;
   private short[] aP3 ;
   private short[] aP4 ;
}

