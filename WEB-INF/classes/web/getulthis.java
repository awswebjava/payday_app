package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getulthis extends GXProcedure
{
   public getulthis( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getulthis.class ), "" );
   }

   public getulthis( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 )
   {
      getulthis.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             short[] aP1 )
   {
      getulthis.this.AV8ConCodigo = aP0;
      getulthis.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV10CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getulthis.this.GXt_int1 = GXv_int2[0] ;
      AV10CliCod = GXt_int1 ;
      /* Using cursor P005N2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV8ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P005N2_A3CliCod[0] ;
         A26ConCodigo = P005N2_A26ConCodigo[0] ;
         A51ForHisNum = P005N2_A51ForHisNum[0] ;
         AV9ForHisNum = A51ForHisNum ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getulthis.this.AV9ForHisNum;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P005N2_A3CliCod = new int[1] ;
      P005N2_A26ConCodigo = new String[] {""} ;
      P005N2_A51ForHisNum = new short[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getulthis__default(),
         new Object[] {
             new Object[] {
            P005N2_A3CliCod, P005N2_A26ConCodigo, P005N2_A51ForHisNum
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9ForHisNum ;
   private short A51ForHisNum ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private String AV8ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P005N2_A3CliCod ;
   private String[] P005N2_A26ConCodigo ;
   private short[] P005N2_A51ForHisNum ;
}

final  class getulthis__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P005N2", "SELECT CliCod, ConCodigo, ForHisNum FROM FormulaHistorico WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo, ForHisNum DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

