package web ;
import com.genexus.*;

public final  class StructSdtsdt_variables_sdt_variablesItem implements Cloneable, java.io.Serializable
{
   public StructSdtsdt_variables_sdt_variablesItem( )
   {
      this( -1, new ModelContext( StructSdtsdt_variables_sdt_variablesItem.class ));
   }

   public StructSdtsdt_variables_sdt_variablesItem( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula = "" ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip = "" ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay = "" ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid = "" ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getOpeclicodformula( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula ;
   }

   public void setOpeclicodformula( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula = value ;
   }

   public String getOpeclidescrip( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip ;
   }

   public void setOpeclidescrip( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip = value ;
   }

   public String getOpecliidmay( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay ;
   }

   public void setOpecliidmay( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay = value ;
   }

   public String getOpecliid( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid ;
   }

   public void setOpecliid( String value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid = value ;
   }

   public boolean getOpecliescant( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant ;
   }

   public void setOpecliescant( boolean value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant = value ;
   }

   public boolean getOpeclialies( )
   {
      return gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies ;
   }

   public void setOpeclialies( boolean value )
   {
      gxTv_Sdtsdt_variables_sdt_variablesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies = value ;
   }

   protected byte gxTv_Sdtsdt_variables_sdt_variablesItem_N ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclicodformula ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliidmay ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliid ;
   protected boolean gxTv_Sdtsdt_variables_sdt_variablesItem_Opecliescant ;
   protected boolean gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclialies ;
   protected String gxTv_Sdtsdt_variables_sdt_variablesItem_Opeclidescrip ;
}

