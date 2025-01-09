package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptogetsubtipos extends GXProcedure
{
   public conceptogetsubtipos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptogetsubtipos.class ), "" );
   }

   public conceptogetsubtipos( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      conceptogetsubtipos.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      conceptogetsubtipos.this.AV8CliCod = aP0;
      conceptogetsubtipos.this.AV9ConCodigo = aP1;
      conceptogetsubtipos.this.aP2 = aP2;
      conceptogetsubtipos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00FS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00FS2_A26ConCodigo[0] ;
         A3CliCod = P00FS2_A3CliCod[0] ;
         A38SubTipoConCod1 = P00FS2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00FS2_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = P00FS2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P00FS2_n39SubTipoConCod2[0] ;
         AV10SubTipoConCod1 = A38SubTipoConCod1 ;
         AV11SubTipoConCod2 = A39SubTipoConCod2 ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conceptogetsubtipos.this.AV10SubTipoConCod1;
      this.aP3[0] = conceptogetsubtipos.this.AV11SubTipoConCod2;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SubTipoConCod1 = "" ;
      AV11SubTipoConCod2 = "" ;
      scmdbuf = "" ;
      P00FS2_A26ConCodigo = new String[] {""} ;
      P00FS2_A3CliCod = new int[1] ;
      P00FS2_A38SubTipoConCod1 = new String[] {""} ;
      P00FS2_n38SubTipoConCod1 = new boolean[] {false} ;
      P00FS2_A39SubTipoConCod2 = new String[] {""} ;
      P00FS2_n39SubTipoConCod2 = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptogetsubtipos__default(),
         new Object[] {
             new Object[] {
            P00FS2_A26ConCodigo, P00FS2_A3CliCod, P00FS2_A38SubTipoConCod1, P00FS2_n38SubTipoConCod1, P00FS2_A39SubTipoConCod2, P00FS2_n39SubTipoConCod2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ConCodigo ;
   private String AV10SubTipoConCod1 ;
   private String AV11SubTipoConCod2 ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00FS2_A26ConCodigo ;
   private int[] P00FS2_A3CliCod ;
   private String[] P00FS2_A38SubTipoConCod1 ;
   private boolean[] P00FS2_n38SubTipoConCod1 ;
   private String[] P00FS2_A39SubTipoConCod2 ;
   private boolean[] P00FS2_n39SubTipoConCod2 ;
}

final  class conceptogetsubtipos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00FS2", "SELECT ConCodigo, CliCod, SubTipoConCod1, SubTipoConCod2 FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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

