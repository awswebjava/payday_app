package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtcategorialegajo extends GXProcedure
{
   public obtcategorialegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtcategorialegajo.class ), "" );
   }

   public obtcategorialegajo( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 )
   {
      obtcategorialegajo.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      obtcategorialegajo.this.AV11CliCod = aP0;
      obtcategorialegajo.this.AV9EmpCod = aP1;
      obtcategorialegajo.this.AV13LiqNro = aP2;
      obtcategorialegajo.this.AV10LegNumero = aP3;
      obtcategorialegajo.this.aP4 = aP4;
      obtcategorialegajo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV13LiqNro, 8, 0))) ;
      if ( (0==AV13LiqNro) )
      {
         /* Using cursor P005T2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6LegNumero = P005T2_A6LegNumero[0] ;
            A1EmpCod = P005T2_A1EmpCod[0] ;
            A3CliCod = P005T2_A3CliCod[0] ;
            A939LegCatCodigo = P005T2_A939LegCatCodigo[0] ;
            n939LegCatCodigo = P005T2_n939LegCatCodigo[0] ;
            A937LegConveCodigo = P005T2_A937LegConveCodigo[0] ;
            n937LegConveCodigo = P005T2_n937LegConveCodigo[0] ;
            AV8CatCodigo = A939LegCatCodigo ;
            AV12ConveCodigo = A937LegConveCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "saca de legajo ", "")+AV8CatCodigo) ;
      }
      else
      {
         /* Using cursor P005T3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV13LiqNro), Integer.valueOf(AV10LegNumero)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A6LegNumero = P005T3_A6LegNumero[0] ;
            A31LiqNro = P005T3_A31LiqNro[0] ;
            A1EmpCod = P005T3_A1EmpCod[0] ;
            A3CliCod = P005T3_A3CliCod[0] ;
            A2113LiqLegCatCodigo = P005T3_A2113LiqLegCatCodigo[0] ;
            A2115LiqLegConvenio = P005T3_A2115LiqLegConvenio[0] ;
            AV8CatCodigo = A2113LiqLegCatCodigo ;
            AV12ConveCodigo = A2115LiqLegConvenio ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         new web.msgdebug_prod(remoteHandle, context).execute( AV16Pgmname, httpContext.getMessage( "saca de liquidacion ", "")+AV8CatCodigo) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = obtcategorialegajo.this.AV8CatCodigo;
      this.aP5[0] = obtcategorialegajo.this.AV12ConveCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CatCodigo = "" ;
      AV12ConveCodigo = "" ;
      AV16Pgmname = "" ;
      scmdbuf = "" ;
      P005T2_A6LegNumero = new int[1] ;
      P005T2_A1EmpCod = new short[1] ;
      P005T2_A3CliCod = new int[1] ;
      P005T2_A939LegCatCodigo = new String[] {""} ;
      P005T2_n939LegCatCodigo = new boolean[] {false} ;
      P005T2_A937LegConveCodigo = new String[] {""} ;
      P005T2_n937LegConveCodigo = new boolean[] {false} ;
      A939LegCatCodigo = "" ;
      A937LegConveCodigo = "" ;
      P005T3_A6LegNumero = new int[1] ;
      P005T3_A31LiqNro = new int[1] ;
      P005T3_A1EmpCod = new short[1] ;
      P005T3_A3CliCod = new int[1] ;
      P005T3_A2113LiqLegCatCodigo = new String[] {""} ;
      P005T3_A2115LiqLegConvenio = new String[] {""} ;
      A2113LiqLegCatCodigo = "" ;
      A2115LiqLegConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtcategorialegajo__default(),
         new Object[] {
             new Object[] {
            P005T2_A6LegNumero, P005T2_A1EmpCod, P005T2_A3CliCod, P005T2_A939LegCatCodigo, P005T2_n939LegCatCodigo, P005T2_A937LegConveCodigo, P005T2_n937LegConveCodigo
            }
            , new Object[] {
            P005T3_A6LegNumero, P005T3_A31LiqNro, P005T3_A1EmpCod, P005T3_A3CliCod, P005T3_A2113LiqLegCatCodigo, P005T3_A2115LiqLegConvenio
            }
         }
      );
      AV16Pgmname = "ObtCategoriaLegajo" ;
      /* GeneXus formulas. */
      AV16Pgmname = "ObtCategoriaLegajo" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LiqNro ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV8CatCodigo ;
   private String AV12ConveCodigo ;
   private String AV16Pgmname ;
   private String scmdbuf ;
   private String A939LegCatCodigo ;
   private String A937LegConveCodigo ;
   private String A2113LiqLegCatCodigo ;
   private String A2115LiqLegConvenio ;
   private boolean n939LegCatCodigo ;
   private boolean n937LegConveCodigo ;
   private String[] aP5 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P005T2_A6LegNumero ;
   private short[] P005T2_A1EmpCod ;
   private int[] P005T2_A3CliCod ;
   private String[] P005T2_A939LegCatCodigo ;
   private boolean[] P005T2_n939LegCatCodigo ;
   private String[] P005T2_A937LegConveCodigo ;
   private boolean[] P005T2_n937LegConveCodigo ;
   private int[] P005T3_A6LegNumero ;
   private int[] P005T3_A31LiqNro ;
   private short[] P005T3_A1EmpCod ;
   private int[] P005T3_A3CliCod ;
   private String[] P005T3_A2113LiqLegCatCodigo ;
   private String[] P005T3_A2115LiqLegConvenio ;
}

final  class obtcategorialegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005T2", "SELECT LegNumero, EmpCod, CliCod, LegCatCodigo, LegConveCodigo FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P005T3", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegCatCodigo, LiqLegConvenio FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

