package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarliquidacionduplicada extends GXProcedure
{
   public validarliquidacionduplicada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarliquidacionduplicada.class ), "" );
   }

   public validarliquidacionduplicada( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              GXBaseCollection<web.Sdtsdt_detalle_sdt_detalleItem> aP2 )
   {
      validarliquidacionduplicada.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXBaseCollection<web.Sdtsdt_detalle_sdt_detalleItem> aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXBaseCollection<web.Sdtsdt_detalle_sdt_detalleItem> aP2 ,
                             boolean[] aP3 )
   {
      validarliquidacionduplicada.this.AV9CliCod = aP0;
      validarliquidacionduplicada.this.AV8EmpCod = aP1;
      validarliquidacionduplicada.this.AV10sdt_detalle = aP2;
      validarliquidacionduplicada.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00OR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00OR2_A31LiqNro[0] ;
         A1EmpCod = P00OR2_A1EmpCod[0] ;
         A3CliCod = P00OR2_A3CliCod[0] ;
         AV12encontrados = (short)(0) ;
         AV13recorridos = (short)(0) ;
         /* Using cursor P00OR3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A394DConCodigo = P00OR3_A394DConCodigo[0] ;
            A6LegNumero = P00OR3_A6LegNumero[0] ;
            A81LiqDSecuencial = P00OR3_A81LiqDSecuencial[0] ;
            AV13recorridos = (short)(AV13recorridos+1) ;
            AV20GXV1 = 1 ;
            while ( AV20GXV1 <= AV10sdt_detalle.size() )
            {
               AV11item = (web.Sdtsdt_detalle_sdt_detalleItem)((web.Sdtsdt_detalle_sdt_detalleItem)AV10sdt_detalle.elementAt(-1+AV20GXV1));
               if ( ! AV11item.getgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado() && ( GXutil.strcmp(AV11item.getgxTv_Sdtsdt_detalle_sdt_detalleItem_Concodigo(), A394DConCodigo) == 0 ) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV11item.setgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado( true );
                  AV12encontrados = (short)(AV12encontrados+1) ;
                  if (true) break;
               }
               AV20GXV1 = (int)(AV20GXV1+1) ;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV12encontrados == AV13recorridos )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV14faltaAlguno = false ;
            AV21GXV2 = 1 ;
            while ( AV21GXV2 <= AV10sdt_detalle.size() )
            {
               AV11item = (web.Sdtsdt_detalle_sdt_detalleItem)((web.Sdtsdt_detalle_sdt_detalleItem)AV10sdt_detalle.elementAt(-1+AV21GXV2));
               if ( ! AV11item.getgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado() )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV14faltaAlguno = true ;
               }
               AV21GXV2 = (int)(AV21GXV2+1) ;
            }
            if ( ! AV14faltaAlguno )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV15duplica = true ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         if ( ! AV15duplica )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV22GXV3 = 1 ;
            while ( AV22GXV3 <= AV10sdt_detalle.size() )
            {
               AV11item = (web.Sdtsdt_detalle_sdt_detalleItem)((web.Sdtsdt_detalle_sdt_detalleItem)AV10sdt_detalle.elementAt(-1+AV22GXV3));
               AV11item.setgxTv_Sdtsdt_detalle_sdt_detalleItem_Encontrado( false );
               AV22GXV3 = (int)(AV22GXV3+1) ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = validarliquidacionduplicada.this.AV15duplica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00OR2_A31LiqNro = new int[1] ;
      P00OR2_A1EmpCod = new short[1] ;
      P00OR2_A3CliCod = new int[1] ;
      P00OR3_A3CliCod = new int[1] ;
      P00OR3_A1EmpCod = new short[1] ;
      P00OR3_A31LiqNro = new int[1] ;
      P00OR3_A394DConCodigo = new String[] {""} ;
      P00OR3_A6LegNumero = new int[1] ;
      P00OR3_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      AV11item = new web.Sdtsdt_detalle_sdt_detalleItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validarliquidacionduplicada__default(),
         new Object[] {
             new Object[] {
            P00OR2_A31LiqNro, P00OR2_A1EmpCod, P00OR2_A3CliCod
            }
            , new Object[] {
            P00OR3_A3CliCod, P00OR3_A1EmpCod, P00OR3_A31LiqNro, P00OR3_A394DConCodigo, P00OR3_A6LegNumero, P00OR3_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short AV12encontrados ;
   private short AV13recorridos ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int AV20GXV1 ;
   private int AV21GXV2 ;
   private int AV22GXV3 ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private boolean AV15duplica ;
   private boolean Cond_result ;
   private boolean AV14faltaAlguno ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00OR2_A31LiqNro ;
   private short[] P00OR2_A1EmpCod ;
   private int[] P00OR2_A3CliCod ;
   private int[] P00OR3_A3CliCod ;
   private short[] P00OR3_A1EmpCod ;
   private int[] P00OR3_A31LiqNro ;
   private String[] P00OR3_A394DConCodigo ;
   private int[] P00OR3_A6LegNumero ;
   private int[] P00OR3_A81LiqDSecuencial ;
   private GXBaseCollection<web.Sdtsdt_detalle_sdt_detalleItem> AV10sdt_detalle ;
   private web.Sdtsdt_detalle_sdt_detalleItem AV11item ;
}

final  class validarliquidacionduplicada__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OR2", "SELECT LiqNro, EmpCod, CliCod FROM Liquidacion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00OR3", "SELECT CliCod, EmpCod, LiqNro, DConCodigo, LegNumero, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

