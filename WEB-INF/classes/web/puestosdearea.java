package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class puestosdearea extends GXProcedure
{
   public puestosdearea( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( puestosdearea.class ), "" );
   }

   public puestosdearea( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem> executeUdp( int aP0 ,
                                                                         String aP1 )
   {
      puestosdearea.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem>[] aP2 )
   {
      puestosdearea.this.AV8CliCod = aP0;
      puestosdearea.this.AV9SecCodigo = aP1;
      puestosdearea.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10sdt_puesto.clear();
      /* Using cursor P01CS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9SecCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A13SecCodigo = P01CS2_A13SecCodigo[0] ;
         A3CliCod = P01CS2_A3CliCod[0] ;
         A1240PuestoCodigo = P01CS2_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = P01CS2_A1241PuestoDescrip[0] ;
         AV11itemPuesto = (web.Sdtsdt_puesto_sdt_puestoItem)new web.Sdtsdt_puesto_sdt_puestoItem(remoteHandle, context);
         AV11itemPuesto.setgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestocodigo( A1240PuestoCodigo );
         AV11itemPuesto.setgxTv_Sdtsdt_puesto_sdt_puestoItem_Puestodescrip( A1241PuestoDescrip );
         AV10sdt_puesto.add(AV11itemPuesto, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = puestosdearea.this.AV10sdt_puesto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10sdt_puesto = new GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem>(web.Sdtsdt_puesto_sdt_puestoItem.class, "sdt_puestoItem", "PayDay", remoteHandle);
      scmdbuf = "" ;
      P01CS2_A13SecCodigo = new String[] {""} ;
      P01CS2_A3CliCod = new int[1] ;
      P01CS2_A1240PuestoCodigo = new String[] {""} ;
      P01CS2_A1241PuestoDescrip = new String[] {""} ;
      A13SecCodigo = "" ;
      A1240PuestoCodigo = "" ;
      A1241PuestoDescrip = "" ;
      AV11itemPuesto = new web.Sdtsdt_puesto_sdt_puestoItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new web.puestosdearea__default(),
         new Object[] {
             new Object[] {
            P01CS2_A13SecCodigo, P01CS2_A3CliCod, P01CS2_A1240PuestoCodigo, P01CS2_A1241PuestoDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9SecCodigo ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
   private String A1241PuestoDescrip ;
   private GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01CS2_A13SecCodigo ;
   private int[] P01CS2_A3CliCod ;
   private String[] P01CS2_A1240PuestoCodigo ;
   private String[] P01CS2_A1241PuestoDescrip ;
   private GXBaseCollection<web.Sdtsdt_puesto_sdt_puestoItem> AV10sdt_puesto ;
   private web.Sdtsdt_puesto_sdt_puestoItem AV11itemPuesto ;
}

final  class puestosdearea__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CS2", "SELECT SecCodigo, CliCod, PuestoCodigo, PuestoDescrip FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

