package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtImportarLiquidacionesWizard2Data extends GxUserType
{
   public SdtImportarLiquidacionesWizard2Data( )
   {
      this(  new ModelContext(SdtImportarLiquidacionesWizard2Data.class));
   }

   public SdtImportarLiquidacionesWizard2Data( ModelContext context )
   {
      super( context, "SdtImportarLiquidacionesWizard2Data");
   }

   public SdtImportarLiquidacionesWizard2Data( int remoteHandle ,
                                               ModelContext context )
   {
      super( remoteHandle, context, "SdtImportarLiquidacionesWizard2Data");
   }

   public SdtImportarLiquidacionesWizard2Data( StructSdtImportarLiquidacionesWizard2Data struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "AuxiliarData") )
            {
               if ( gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata == null )
               {
                  gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata = new GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata.readxml(oReader, "AuxiliarData") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "AuxiliarData") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "ImportarLiquidacionesWizard2Data" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      if ( gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata.writexml(oWriter, "AuxiliarData", sNameSpace1, sIncludeState);
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      if ( gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata != null )
      {
         AddObjectProperty("AuxiliarData", gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata, false, false);
      }
   }

   public GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> getgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata( )
   {
      if ( gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata == null )
      {
         gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata = new GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "PayDay", remoteHandle);
      }
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_N = (byte)(0) ;
      return gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata ;
   }

   public void setgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata( GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_N = (byte)(0) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata = value ;
   }

   public void setgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_SetNull( )
   {
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N = (byte)(1) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata = null ;
   }

   public boolean getgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_IsNull( )
   {
      if ( gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N( )
   {
      return gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N = (byte)(1) ;
      gxTv_SdtImportarLiquidacionesWizard2Data_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtImportarLiquidacionesWizard2Data_N ;
   }

   public web.SdtImportarLiquidacionesWizard2Data Clone( )
   {
      return (web.SdtImportarLiquidacionesWizard2Data)(clone()) ;
   }

   public void setStruct( web.StructSdtImportarLiquidacionesWizard2Data struct )
   {
      GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux = new GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "PayDay", remoteHandle);
      Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux1 = struct.getAuxiliardata();
      if (gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux1.size(); i++)
         {
            gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux.add(new web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem(gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata(gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtImportarLiquidacionesWizard2Data getStruct( )
   {
      web.StructSdtImportarLiquidacionesWizard2Data struct = new web.StructSdtImportarLiquidacionesWizard2Data ();
      struct.setAuxiliardata(getgxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_N ;
   protected byte gxTv_SdtImportarLiquidacionesWizard2Data_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata_aux ;
   protected GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtImportarLiquidacionesWizard2Data_Auxiliardata=null ;
}

