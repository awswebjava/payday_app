package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarpaisreligionyorigen extends GXProcedure
{
   public inicializarpaisreligionyorigen( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarpaisreligionyorigen.class ), "" );
   }

   public inicializarpaisreligionyorigen( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      inicializarpaisreligionyorigen.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P020Y2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1229ReligId = P020Y2_A1229ReligId[0] ;
         /*
            INSERT RECORD ON TABLE PaisReligion

         */
         A46PaiCod = AV8PaiCod ;
         A1253PaiReligion = A1229ReligId ;
         /* Using cursor P020Y3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1253PaiReligion});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisReligion");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P020Y4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1231OrigId = P020Y4_A1231OrigId[0] ;
         /*
            INSERT RECORD ON TABLE PaisOrigen

         */
         A46PaiCod = AV8PaiCod ;
         A1282PaiOrigen = A1231OrigId ;
         /* Using cursor P020Y5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A1282PaiOrigen});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("PaisOrigen");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarpaisreligionyorigen");
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
      P020Y2_A1229ReligId = new String[] {""} ;
      A1229ReligId = "" ;
      A1253PaiReligion = "" ;
      Gx_emsg = "" ;
      P020Y4_A1231OrigId = new String[] {""} ;
      A1231OrigId = "" ;
      A1282PaiOrigen = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarpaisreligionyorigen__default(),
         new Object[] {
             new Object[] {
            P020Y2_A1229ReligId
            }
            , new Object[] {
            }
            , new Object[] {
            P020Y4_A1231OrigId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int GX_INS150 ;
   private int GX_INS152 ;
   private String scmdbuf ;
   private String A1229ReligId ;
   private String A1253PaiReligion ;
   private String Gx_emsg ;
   private String A1231OrigId ;
   private String A1282PaiOrigen ;
   private IDataStoreProvider pr_default ;
   private String[] P020Y2_A1229ReligId ;
   private String[] P020Y4_A1231OrigId ;
}

final  class inicializarpaisreligionyorigen__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020Y2", "SELECT ReligId FROM Religion ORDER BY ReligId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P020Y3", "SAVEPOINT gxupdate;INSERT INTO PaisReligion(PaiCod, PaiReligion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P020Y4", "SELECT OrigId FROM Origen ORDER BY OrigId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P020Y5", "SAVEPOINT gxupdate;INSERT INTO PaisOrigen(PaiCod, PaiOrigen) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

