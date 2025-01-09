package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuitempredeterminados extends GXProcedure
{
   public getmenuitempredeterminados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuitempredeterminados.class ), "" );
   }

   public getmenuitempredeterminados( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( byte aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      getmenuitempredeterminados.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( byte aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( byte aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      getmenuitempredeterminados.this.AV9PerfilId = aP0;
      getmenuitempredeterminados.this.AV10MenuItemId = aP1;
      getmenuitempredeterminados.this.aP2 = aP2;
      getmenuitempredeterminados.this.aP3 = aP3;
      getmenuitempredeterminados.this.aP4 = aP4;
      getmenuitempredeterminados.this.aP5 = aP5;
      getmenuitempredeterminados.this.aP6 = aP6;
      getmenuitempredeterminados.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01UJ2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV9PerfilId), AV10MenuItemId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1937MenuItemId = P01UJ2_A1937MenuItemId[0] ;
         A1925PerfilId = P01UJ2_A1925PerfilId[0] ;
         A1960MitemIcoImgNom = P01UJ2_A1960MitemIcoImgNom[0] ;
         A1954MItemBienImgNom = P01UJ2_A1954MItemBienImgNom[0] ;
         A1959MItemIcoImgExt = P01UJ2_A1959MItemIcoImgExt[0] ;
         A1953MItemBienImgExt = P01UJ2_A1953MItemBienImgExt[0] ;
         A1939MenuItemTitulo = P01UJ2_A1939MenuItemTitulo[0] ;
         A1957MItemIcoSVG = P01UJ2_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UJ2_n1957MItemIcoSVG[0] ;
         A1958MitemIcoImg = P01UJ2_A1958MitemIcoImg[0] ;
         A1952MItemBienImgDef = P01UJ2_A1952MItemBienImgDef[0] ;
         A1955MItemBienTitDef = P01UJ2_A1955MItemBienTitDef[0] ;
         A1956MItemBienTextDef = P01UJ2_A1956MItemBienTextDef[0] ;
         AV8MenuItemTitulo = A1939MenuItemTitulo ;
         AV11MItemIcoSVG = A1957MItemIcoSVG ;
         AV15MitemIcoImg = A1958MitemIcoImg ;
         AV14MItemBienImgDef = A1952MItemBienImgDef ;
         AV13MItemBienTitDef = A1955MItemBienTitDef ;
         AV12MItemBienTextDef = A1956MItemBienTextDef ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getmenuitempredeterminados.this.AV8MenuItemTitulo;
      this.aP3[0] = getmenuitempredeterminados.this.AV11MItemIcoSVG;
      this.aP4[0] = getmenuitempredeterminados.this.AV15MitemIcoImg;
      this.aP5[0] = getmenuitempredeterminados.this.AV14MItemBienImgDef;
      this.aP6[0] = getmenuitempredeterminados.this.AV13MItemBienTitDef;
      this.aP7[0] = getmenuitempredeterminados.this.AV12MItemBienTextDef;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8MenuItemTitulo = "" ;
      AV11MItemIcoSVG = "" ;
      AV15MitemIcoImg = "" ;
      AV14MItemBienImgDef = "" ;
      AV13MItemBienTitDef = "" ;
      AV12MItemBienTextDef = "" ;
      scmdbuf = "" ;
      P01UJ2_A1937MenuItemId = new String[] {""} ;
      P01UJ2_A1925PerfilId = new byte[1] ;
      P01UJ2_A1960MitemIcoImgNom = new String[] {""} ;
      P01UJ2_A1954MItemBienImgNom = new String[] {""} ;
      P01UJ2_A1959MItemIcoImgExt = new String[] {""} ;
      P01UJ2_A1953MItemBienImgExt = new String[] {""} ;
      P01UJ2_A1939MenuItemTitulo = new String[] {""} ;
      P01UJ2_A1957MItemIcoSVG = new String[] {""} ;
      P01UJ2_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UJ2_A1958MitemIcoImg = new String[] {""} ;
      P01UJ2_A1952MItemBienImgDef = new String[] {""} ;
      P01UJ2_A1955MItemBienTitDef = new String[] {""} ;
      P01UJ2_A1956MItemBienTextDef = new String[] {""} ;
      A1937MenuItemId = "" ;
      A1960MitemIcoImgNom = "" ;
      A1954MItemBienImgNom = "" ;
      A1959MItemIcoImgExt = "" ;
      A1953MItemBienImgExt = "" ;
      A1939MenuItemTitulo = "" ;
      A1957MItemIcoSVG = "" ;
      A1958MitemIcoImg = "" ;
      A1952MItemBienImgDef = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmenuitempredeterminados__default(),
         new Object[] {
             new Object[] {
            P01UJ2_A1937MenuItemId, P01UJ2_A1925PerfilId, P01UJ2_A1960MitemIcoImgNom, P01UJ2_A1954MItemBienImgNom, P01UJ2_A1959MItemIcoImgExt, P01UJ2_A1953MItemBienImgExt, P01UJ2_A1939MenuItemTitulo, P01UJ2_A1957MItemIcoSVG, P01UJ2_n1957MItemIcoSVG, P01UJ2_A1958MitemIcoImg,
            P01UJ2_A1952MItemBienImgDef, P01UJ2_A1955MItemBienTitDef, P01UJ2_A1956MItemBienTextDef
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9PerfilId ;
   private byte A1925PerfilId ;
   private short Gx_err ;
   private String AV11MItemIcoSVG ;
   private String scmdbuf ;
   private String A1959MItemIcoImgExt ;
   private String A1953MItemBienImgExt ;
   private String A1957MItemIcoSVG ;
   private boolean n1957MItemIcoSVG ;
   private String AV12MItemBienTextDef ;
   private String A1956MItemBienTextDef ;
   private String AV15MitemIcoImg ;
   private String AV14MItemBienImgDef ;
   private String A1958MitemIcoImg ;
   private String A1952MItemBienImgDef ;
   private String AV10MenuItemId ;
   private String AV8MenuItemTitulo ;
   private String AV13MItemBienTitDef ;
   private String A1937MenuItemId ;
   private String A1960MitemIcoImgNom ;
   private String A1954MItemBienImgNom ;
   private String A1939MenuItemTitulo ;
   private String A1955MItemBienTitDef ;
   private String[] aP7 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UJ2_A1937MenuItemId ;
   private byte[] P01UJ2_A1925PerfilId ;
   private String[] P01UJ2_A1960MitemIcoImgNom ;
   private String[] P01UJ2_A1954MItemBienImgNom ;
   private String[] P01UJ2_A1959MItemIcoImgExt ;
   private String[] P01UJ2_A1953MItemBienImgExt ;
   private String[] P01UJ2_A1939MenuItemTitulo ;
   private String[] P01UJ2_A1957MItemIcoSVG ;
   private boolean[] P01UJ2_n1957MItemIcoSVG ;
   private String[] P01UJ2_A1958MitemIcoImg ;
   private String[] P01UJ2_A1952MItemBienImgDef ;
   private String[] P01UJ2_A1955MItemBienTitDef ;
   private String[] P01UJ2_A1956MItemBienTextDef ;
}

final  class getmenuitempredeterminados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UJ2", "SELECT MenuItemId, PerfilId, MitemIcoImgNom, MItemBienImgNom, MItemIcoImgExt, MItemBienImgExt, MenuItemTitulo, MItemIcoSVG, MitemIcoImg, MItemBienImgDef, MItemBienTitDef, MItemBienTextDef FROM MenuItem WHERE PerfilId = ? and MenuItemId = ( ?) ORDER BY PerfilId, MenuItemId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getBLOBFile(9, rslt.getString(5, 20), rslt.getVarchar(3));
               ((String[]) buf[10])[0] = rslt.getBLOBFile(10, rslt.getString(6, 20), rslt.getVarchar(4));
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40);
               return;
      }
   }

}

