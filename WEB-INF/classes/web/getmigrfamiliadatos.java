package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmigrfamiliadatos extends GXProcedure
{
   public getmigrfamiliadatos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmigrfamiliadatos.class ), "" );
   }

   public getmigrfamiliadatos( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             java.util.Date[] aP9 )
   {
      getmigrfamiliadatos.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        java.util.Date[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             java.util.Date[] aP9 ,
                             String[] aP10 )
   {
      getmigrfamiliadatos.this.AV8CliCod = aP0;
      getmigrfamiliadatos.this.AV9EmpCod = aP1;
      getmigrfamiliadatos.this.AV16MigrLegNumero = aP2;
      getmigrfamiliadatos.this.AV10MigrLegFamSec = aP3;
      getmigrfamiliadatos.this.aP4 = aP4;
      getmigrfamiliadatos.this.aP5 = aP5;
      getmigrfamiliadatos.this.aP6 = aP6;
      getmigrfamiliadatos.this.aP7 = aP7;
      getmigrfamiliadatos.this.aP8 = aP8;
      getmigrfamiliadatos.this.aP9 = aP9;
      getmigrfamiliadatos.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01YQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV16MigrLegNumero), Short.valueOf(AV10MigrLegFamSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2078MigrLegFamSec = P01YQ2_A2078MigrLegFamSec[0] ;
         A87MigrLegNumero = P01YQ2_A87MigrLegNumero[0] ;
         A1EmpCod = P01YQ2_A1EmpCod[0] ;
         A3CliCod = P01YQ2_A3CliCod[0] ;
         A2079MigrLegFamParen = P01YQ2_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = P01YQ2_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = P01YQ2_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = P01YQ2_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = P01YQ2_A2086MigrLegFamDiscap[0] ;
         A2089MigrLegFamFecNac = P01YQ2_A2089MigrLegFamFecNac[0] ;
         A2088MigrLegFamNomApe = P01YQ2_A2088MigrLegFamNomApe[0] ;
         AV14MigrLegFamParen = A2079MigrLegFamParen ;
         AV13MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         AV12MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         AV11MigrLegFamAdh = A2082MigrLegFamAdh ;
         AV17MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         AV19MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         AV18MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug7(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "nadita", "")+AV15MigrLegFormaPago) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getmigrfamiliadatos.this.AV11MigrLegFamAdh;
      this.aP5[0] = getmigrfamiliadatos.this.AV12MigrLegFamDedGan;
      this.aP6[0] = getmigrfamiliadatos.this.AV13MigrLegFamNroDoc;
      this.aP7[0] = getmigrfamiliadatos.this.AV14MigrLegFamParen;
      this.aP8[0] = getmigrfamiliadatos.this.AV17MigrLegFamDiscap;
      this.aP9[0] = getmigrfamiliadatos.this.AV19MigrLegFamFecNac;
      this.aP10[0] = getmigrfamiliadatos.this.AV18MigrLegFamNomApe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11MigrLegFamAdh = "" ;
      AV12MigrLegFamDedGan = DecimalUtil.ZERO ;
      AV13MigrLegFamNroDoc = "" ;
      AV14MigrLegFamParen = "" ;
      AV17MigrLegFamDiscap = "" ;
      AV19MigrLegFamFecNac = GXutil.nullDate() ;
      AV18MigrLegFamNomApe = "" ;
      scmdbuf = "" ;
      P01YQ2_A2078MigrLegFamSec = new short[1] ;
      P01YQ2_A87MigrLegNumero = new int[1] ;
      P01YQ2_A1EmpCod = new short[1] ;
      P01YQ2_A3CliCod = new int[1] ;
      P01YQ2_A2079MigrLegFamParen = new String[] {""} ;
      P01YQ2_A2080MigrLegFamNroDoc = new String[] {""} ;
      P01YQ2_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01YQ2_A2082MigrLegFamAdh = new String[] {""} ;
      P01YQ2_A2086MigrLegFamDiscap = new String[] {""} ;
      P01YQ2_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      P01YQ2_A2088MigrLegFamNomApe = new String[] {""} ;
      A2079MigrLegFamParen = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2082MigrLegFamAdh = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      A2088MigrLegFamNomApe = "" ;
      AV23Pgmname = "" ;
      AV15MigrLegFormaPago = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmigrfamiliadatos__default(),
         new Object[] {
             new Object[] {
            P01YQ2_A2078MigrLegFamSec, P01YQ2_A87MigrLegNumero, P01YQ2_A1EmpCod, P01YQ2_A3CliCod, P01YQ2_A2079MigrLegFamParen, P01YQ2_A2080MigrLegFamNroDoc, P01YQ2_A2081MigrLegFamDedGan, P01YQ2_A2082MigrLegFamAdh, P01YQ2_A2086MigrLegFamDiscap, P01YQ2_A2089MigrLegFamFecNac,
            P01YQ2_A2088MigrLegFamNomApe
            }
         }
      );
      AV23Pgmname = "getMigrFamiliaDatos" ;
      /* GeneXus formulas. */
      AV23Pgmname = "getMigrFamiliaDatos" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10MigrLegFamSec ;
   private short A2078MigrLegFamSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV16MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12MigrLegFamDedGan ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String AV11MigrLegFamAdh ;
   private String AV17MigrLegFamDiscap ;
   private String scmdbuf ;
   private String A2082MigrLegFamAdh ;
   private String A2086MigrLegFamDiscap ;
   private String AV23Pgmname ;
   private java.util.Date AV19MigrLegFamFecNac ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private String AV13MigrLegFamNroDoc ;
   private String AV14MigrLegFamParen ;
   private String AV18MigrLegFamNomApe ;
   private String A2079MigrLegFamParen ;
   private String A2080MigrLegFamNroDoc ;
   private String A2088MigrLegFamNomApe ;
   private String AV15MigrLegFormaPago ;
   private String[] aP10 ;
   private String[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private java.util.Date[] aP9 ;
   private IDataStoreProvider pr_default ;
   private short[] P01YQ2_A2078MigrLegFamSec ;
   private int[] P01YQ2_A87MigrLegNumero ;
   private short[] P01YQ2_A1EmpCod ;
   private int[] P01YQ2_A3CliCod ;
   private String[] P01YQ2_A2079MigrLegFamParen ;
   private String[] P01YQ2_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] P01YQ2_A2081MigrLegFamDedGan ;
   private String[] P01YQ2_A2082MigrLegFamAdh ;
   private String[] P01YQ2_A2086MigrLegFamDiscap ;
   private java.util.Date[] P01YQ2_A2089MigrLegFamFecNac ;
   private String[] P01YQ2_A2088MigrLegFamNomApe ;
}

final  class getmigrfamiliadatos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01YQ2", "SELECT MigrLegFamSec, MigrLegNumero, EmpCod, CliCod, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamFecNac, MigrLegFamNomApe FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? and MigrLegFamSec = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

