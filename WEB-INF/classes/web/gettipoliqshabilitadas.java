package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoliqshabilitadas extends GXProcedure
{
   public gettipoliqshabilitadas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoliqshabilitadas.class ), "" );
   }

   public gettipoliqshabilitadas( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        boolean aP1 ,
                        GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             boolean aP1 ,
                             GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> aP2 )
   {
      gettipoliqshabilitadas.this.AV9CliCod = aP0;
      gettipoliqshabilitadas.this.AV10TLiqHabilitada = aP1;
      gettipoliqshabilitadas.this.AV11sdt_tipo_liqs = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01OP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Boolean.valueOf(AV10TLiqHabilitada)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A341TLiqHabilitada = P01OP2_A341TLiqHabilitada[0] ;
         A3CliCod = P01OP2_A3CliCod[0] ;
         A32TLiqCod = P01OP2_A32TLiqCod[0] ;
         A340TliqDesc = P01OP2_A340TliqDesc[0] ;
         AV12item = (web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem)new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
         AV12item.setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqcod( A32TLiqCod );
         AV12item.setgxTv_Sdtsdt_tipo_liqs_sdt_tipo_liqsItem_Tliqdesc( A340TliqDesc );
         AV11sdt_tipo_liqs.add(AV12item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
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
      P01OP2_A341TLiqHabilitada = new boolean[] {false} ;
      P01OP2_A3CliCod = new int[1] ;
      P01OP2_A32TLiqCod = new String[] {""} ;
      P01OP2_A340TliqDesc = new String[] {""} ;
      A32TLiqCod = "" ;
      A340TliqDesc = "" ;
      AV12item = new web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipoliqshabilitadas__default(),
         new Object[] {
             new Object[] {
            P01OP2_A341TLiqHabilitada, P01OP2_A3CliCod, P01OP2_A32TLiqCod, P01OP2_A340TliqDesc
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private boolean AV10TLiqHabilitada ;
   private boolean A341TLiqHabilitada ;
   private String A340TliqDesc ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01OP2_A341TLiqHabilitada ;
   private int[] P01OP2_A3CliCod ;
   private String[] P01OP2_A32TLiqCod ;
   private String[] P01OP2_A340TliqDesc ;
   private GXBaseCollection<web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem> AV11sdt_tipo_liqs ;
   private web.Sdtsdt_tipo_liqs_sdt_tipo_liqsItem AV12item ;
}

final  class gettipoliqshabilitadas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01OP2", "SELECT TLiqHabilitada, CliCod, TLiqCod, TliqDesc FROM TipoLiquidacion WHERE (CliCod = ?) AND (TLiqHabilitada = ?) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               return;
      }
   }

}

