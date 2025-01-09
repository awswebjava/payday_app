package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoaplicatipoliq extends GXProcedure
{
   public conceptoaplicatipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoaplicatipoliq.class ), "" );
   }

   public conceptoaplicatipoliq( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 ,
                              String aP5 )
   {
      conceptoaplicatipoliq.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             boolean[] aP6 )
   {
      conceptoaplicatipoliq.this.AV8CliCod = aP0;
      conceptoaplicatipoliq.this.AV11EmpCod = aP1;
      conceptoaplicatipoliq.this.AV9LiqNro = aP2;
      conceptoaplicatipoliq.this.AV20LegNumero = aP3;
      conceptoaplicatipoliq.this.AV12ConCodigo = aP4;
      conceptoaplicatipoliq.this.AV21parmTLiqCod = aP5;
      conceptoaplicatipoliq.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV21parmTLiqCod)==0) )
      {
         AV10TLiqCod = AV21parmTLiqCod ;
         AV22chequearTodos = false ;
      }
      else
      {
         AV22chequearTodos = true ;
         /* Using cursor P00PD2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV9LiqNro)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A31LiqNro = P00PD2_A31LiqNro[0] ;
            A1EmpCod = P00PD2_A1EmpCod[0] ;
            A3CliCod = P00PD2_A3CliCod[0] ;
            A32TLiqCod = P00PD2_A32TLiqCod[0] ;
            n32TLiqCod = P00PD2_n32TLiqCod[0] ;
            AV10TLiqCod = A32TLiqCod ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV12ConCodigo)+httpContext.getMessage( " tliqcod ", "")+GXutil.trim( AV10TLiqCod)) ;
      GXv_boolean1[0] = AV13aplica ;
      new web.conceptotienetipoliq(remoteHandle, context).execute( AV8CliCod, AV12ConCodigo, AV10TLiqCod, GXv_boolean1) ;
      conceptoaplicatipoliq.this.AV13aplica = GXv_boolean1[0] ;
      if ( ! AV13aplica && ( AV22chequearTodos ) )
      {
         AV28GXLvl19 = (byte)(0) ;
         /* Using cursor P00PD3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), AV12ConCodigo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A26ConCodigo = P00PD3_A26ConCodigo[0] ;
            A3CliCod = P00PD3_A3CliCod[0] ;
            A32TLiqCod = P00PD3_A32TLiqCod[0] ;
            n32TLiqCod = P00PD3_n32TLiqCod[0] ;
            AV28GXLvl19 = (byte)(1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV28GXLvl19 == 0 )
         {
            AV13aplica = true ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "aplica todos", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = conceptoaplicatipoliq.this.AV13aplica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TLiqCod = "" ;
      scmdbuf = "" ;
      P00PD2_A31LiqNro = new int[1] ;
      P00PD2_A1EmpCod = new short[1] ;
      P00PD2_A3CliCod = new int[1] ;
      P00PD2_A32TLiqCod = new String[] {""} ;
      P00PD2_n32TLiqCod = new boolean[] {false} ;
      A32TLiqCod = "" ;
      AV27Pgmname = "" ;
      GXv_boolean1 = new boolean[1] ;
      P00PD3_A26ConCodigo = new String[] {""} ;
      P00PD3_A3CliCod = new int[1] ;
      P00PD3_A32TLiqCod = new String[] {""} ;
      P00PD3_n32TLiqCod = new boolean[] {false} ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoaplicatipoliq__default(),
         new Object[] {
             new Object[] {
            P00PD2_A31LiqNro, P00PD2_A1EmpCod, P00PD2_A3CliCod, P00PD2_A32TLiqCod, P00PD2_n32TLiqCod
            }
            , new Object[] {
            P00PD3_A26ConCodigo, P00PD3_A3CliCod, P00PD3_A32TLiqCod
            }
         }
      );
      AV27Pgmname = "ConceptoAplicaTipoLiq" ;
      /* GeneXus formulas. */
      AV27Pgmname = "ConceptoAplicaTipoLiq" ;
      Gx_err = (short)(0) ;
   }

   private byte AV28GXLvl19 ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV9LiqNro ;
   private int AV20LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV12ConCodigo ;
   private String AV21parmTLiqCod ;
   private String AV10TLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV27Pgmname ;
   private String A26ConCodigo ;
   private boolean AV13aplica ;
   private boolean AV22chequearTodos ;
   private boolean n32TLiqCod ;
   private boolean GXv_boolean1[] ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00PD2_A31LiqNro ;
   private short[] P00PD2_A1EmpCod ;
   private int[] P00PD2_A3CliCod ;
   private String[] P00PD2_A32TLiqCod ;
   private boolean[] P00PD2_n32TLiqCod ;
   private String[] P00PD3_A26ConCodigo ;
   private int[] P00PD3_A3CliCod ;
   private String[] P00PD3_A32TLiqCod ;
   private boolean[] P00PD3_n32TLiqCod ;
}

final  class conceptoaplicatipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00PD2", "SELECT LiqNro, EmpCod, CliCod, TLiqCod FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00PD3", "SELECT ConCodigo, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

