package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethorassemananormalporlegajo extends GXProcedure
{
   public gethorassemananormalporlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethorassemananormalporlegajo.class ), "" );
   }

   public gethorassemananormalporlegajo( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 )
   {
      gethorassemananormalporlegajo.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      gethorassemananormalporlegajo.this.AV14CliCod = aP0;
      gethorassemananormalporlegajo.this.AV16EmpCod = aP1;
      gethorassemananormalporlegajo.this.AV15LegNumero = aP2;
      gethorassemananormalporlegajo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV8PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV14CliCod, GXv_int1) ;
      gethorassemananormalporlegajo.this.AV8PaiCod = GXv_int1[0] ;
      GXv_char2[0] = AV9ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV14CliCod, AV16EmpCod, AV15LegNumero, GXv_char2) ;
      gethorassemananormalporlegajo.this.AV9ConveCodigo = GXv_char2[0] ;
      AV17LegTipoTra.clear();
      GXv_decimal3[0] = AV11horasSemanaCompleta ;
      new web.gethorassemananormal(remoteHandle, context).execute( AV14CliCod, AV16EmpCod, AV15LegNumero, AV8PaiCod, AV9ConveCodigo, AV17LegTipoTra, GXv_decimal3) ;
      gethorassemananormalporlegajo.this.AV11horasSemanaCompleta = GXv_decimal3[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gethorassemananormalporlegajo.this.AV11horasSemanaCompleta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11horasSemanaCompleta = DecimalUtil.ZERO ;
      GXv_int1 = new short[1] ;
      AV9ConveCodigo = "" ;
      GXv_char2 = new String[1] ;
      AV17LegTipoTra = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV16EmpCod ;
   private short AV8PaiCod ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV15LegNumero ;
   private java.math.BigDecimal AV11horasSemanaCompleta ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV9ConveCodigo ;
   private String GXv_char2[] ;
   private java.math.BigDecimal[] aP3 ;
   private GXSimpleCollection<String> AV17LegTipoTra ;
}

