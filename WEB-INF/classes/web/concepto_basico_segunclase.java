package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class concepto_basico_segunclase extends GXProcedure
{
   public concepto_basico_segunclase( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( concepto_basico_segunclase.class ), "" );
   }

   public concepto_basico_segunclase( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      concepto_basico_segunclase.this.aP3 = new String[] {""};
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
      concepto_basico_segunclase.this.AV9CliCod = aP0;
      concepto_basico_segunclase.this.AV10EmpCod = aP1;
      concepto_basico_segunclase.this.AV11LegNumero = aP2;
      concepto_basico_segunclase.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV16tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, 0, AV11LegNumero, (short)(0), "", "", GXv_char1) ;
      concepto_basico_segunclase.this.AV16tipo_tarifa = GXv_char1[0] ;
      GXv_char1[0] = AV8ConCodigo ;
      new web.getconceptobasicoporclase(remoteHandle, context).execute( AV9CliCod, AV16tipo_tarifa, GXv_char1) ;
      concepto_basico_segunclase.this.AV8ConCodigo = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = concepto_basico_segunclase.this.AV8ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConCodigo = "" ;
      AV16tipo_tarifa = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private String AV8ConCodigo ;
   private String AV16tipo_tarifa ;
   private String GXv_char1[] ;
   private String[] aP3 ;
}

