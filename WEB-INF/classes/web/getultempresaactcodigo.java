package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultempresaactcodigo extends GXProcedure
{
   public getultempresaactcodigo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultempresaactcodigo.class ), "" );
   }

   public getultempresaactcodigo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String[] aP1 )
   {
      getultempresaactcodigo.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      getultempresaactcodigo.this.AV8CliCod = aP0;
      getultempresaactcodigo.this.aP1 = aP1;
      getultempresaactcodigo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00OT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00OT2_A3CliCod[0] ;
         A43ActCodigo = P00OT2_A43ActCodigo[0] ;
         n43ActCodigo = P00OT2_n43ActCodigo[0] ;
         A108ActDescrip = P00OT2_A108ActDescrip[0] ;
         A1EmpCod = P00OT2_A1EmpCod[0] ;
         A108ActDescrip = P00OT2_A108ActDescrip[0] ;
         AV9ActCodigo = A43ActCodigo ;
         AV10ActDescrip = A108ActDescrip ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getultempresaactcodigo.this.AV9ActCodigo;
      this.aP2[0] = getultempresaactcodigo.this.AV10ActDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ActCodigo = "" ;
      AV10ActDescrip = "" ;
      scmdbuf = "" ;
      P00OT2_A3CliCod = new int[1] ;
      P00OT2_A43ActCodigo = new String[] {""} ;
      P00OT2_n43ActCodigo = new boolean[] {false} ;
      P00OT2_A108ActDescrip = new String[] {""} ;
      P00OT2_A1EmpCod = new short[1] ;
      A43ActCodigo = "" ;
      A108ActDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultempresaactcodigo__default(),
         new Object[] {
             new Object[] {
            P00OT2_A3CliCod, P00OT2_A43ActCodigo, P00OT2_n43ActCodigo, P00OT2_A108ActDescrip, P00OT2_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9ActCodigo ;
   private String scmdbuf ;
   private String A43ActCodigo ;
   private boolean n43ActCodigo ;
   private String AV10ActDescrip ;
   private String A108ActDescrip ;
   private String[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00OT2_A3CliCod ;
   private String[] P00OT2_A43ActCodigo ;
   private boolean[] P00OT2_n43ActCodigo ;
   private String[] P00OT2_A108ActDescrip ;
   private short[] P00OT2_A1EmpCod ;
}

final  class getultempresaactcodigo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OT2", "SELECT T1.CliCod, T1.ActCodigo, T2.ActDescrip, T1.EmpCod FROM (Empresa T1 LEFT JOIN Actividad T2 ON T2.ActCodigo = T1.ActCodigo) WHERE T1.CliCod = ? ORDER BY T1.CliCod, T1.EmpCod DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 8);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
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
               return;
      }
   }

}

