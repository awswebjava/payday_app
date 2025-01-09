package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConceptosAfipWizardData extends GxUserType
{
   public SdtConceptosAfipWizardData( )
   {
      this(  new ModelContext(SdtConceptosAfipWizardData.class));
   }

   public SdtConceptosAfipWizardData( ModelContext context )
   {
      super( context, "SdtConceptosAfipWizardData");
   }

   public SdtConceptosAfipWizardData( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtConceptosAfipWizardData");
   }

   public SdtConceptosAfipWizardData( StructSdtConceptosAfipWizardData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Concepto1") )
            {
               if ( gxTv_SdtConceptosAfipWizardData_Concepto1 == null )
               {
                  gxTv_SdtConceptosAfipWizardData_Concepto1 = new web.SdtConceptosAfipWizardData_Concepto1(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtConceptosAfipWizardData_Concepto1.readxml(oReader, "Concepto1") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Completado") )
            {
               if ( gxTv_SdtConceptosAfipWizardData_Completado == null )
               {
                  gxTv_SdtConceptosAfipWizardData_Completado = new web.SdtConceptosAfipWizardData_Completado(remoteHandle, context);
               }
               GXSoapError = gxTv_SdtConceptosAfipWizardData_Completado.readxml(oReader, "Completado") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AuxiliarData") )
            {
               if ( gxTv_SdtConceptosAfipWizardData_Auxiliardata == null )
               {
                  gxTv_SdtConceptosAfipWizardData_Auxiliardata = new GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "PayDay", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtConceptosAfipWizardData_Auxiliardata.readxml(oReader, "AuxiliarData") ;
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
         sName = "ConceptosAfipWizardData" ;
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
      if ( gxTv_SdtConceptosAfipWizardData_Concepto1 != null )
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
         gxTv_SdtConceptosAfipWizardData_Concepto1.writexml(oWriter, "Concepto1", sNameSpace1);
      }
      if ( gxTv_SdtConceptosAfipWizardData_Completado != null )
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
         gxTv_SdtConceptosAfipWizardData_Completado.writexml(oWriter, "Completado", sNameSpace1);
      }
      if ( gxTv_SdtConceptosAfipWizardData_Auxiliardata != null )
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
         gxTv_SdtConceptosAfipWizardData_Auxiliardata.writexml(oWriter, "AuxiliarData", sNameSpace1, sIncludeState);
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
      if ( gxTv_SdtConceptosAfipWizardData_Concepto1 != null )
      {
         AddObjectProperty("Concepto1", gxTv_SdtConceptosAfipWizardData_Concepto1, false, false);
      }
      if ( gxTv_SdtConceptosAfipWizardData_Completado != null )
      {
         AddObjectProperty("Completado", gxTv_SdtConceptosAfipWizardData_Completado, false, false);
      }
      if ( gxTv_SdtConceptosAfipWizardData_Auxiliardata != null )
      {
         AddObjectProperty("AuxiliarData", gxTv_SdtConceptosAfipWizardData_Auxiliardata, false, false);
      }
   }

   public web.SdtConceptosAfipWizardData_Concepto1 getgxTv_SdtConceptosAfipWizardData_Concepto1( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Concepto1 == null )
      {
         gxTv_SdtConceptosAfipWizardData_Concepto1 = new web.SdtConceptosAfipWizardData_Concepto1(remoteHandle, context);
      }
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      return gxTv_SdtConceptosAfipWizardData_Concepto1 ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1( web.SdtConceptosAfipWizardData_Concepto1 value )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1 = value;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Concepto1_SetNull( )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Concepto1 = (web.SdtConceptosAfipWizardData_Concepto1)null;
   }

   public boolean getgxTv_SdtConceptosAfipWizardData_Concepto1_IsNull( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Concepto1 == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtConceptosAfipWizardData_Concepto1_N( )
   {
      return gxTv_SdtConceptosAfipWizardData_Concepto1_N ;
   }

   public web.SdtConceptosAfipWizardData_Completado getgxTv_SdtConceptosAfipWizardData_Completado( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Completado == null )
      {
         gxTv_SdtConceptosAfipWizardData_Completado = new web.SdtConceptosAfipWizardData_Completado(remoteHandle, context);
      }
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      return gxTv_SdtConceptosAfipWizardData_Completado ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Completado( web.SdtConceptosAfipWizardData_Completado value )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Completado = value;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Completado_SetNull( )
   {
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Completado = (web.SdtConceptosAfipWizardData_Completado)null;
   }

   public boolean getgxTv_SdtConceptosAfipWizardData_Completado_IsNull( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Completado == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtConceptosAfipWizardData_Completado_N( )
   {
      return gxTv_SdtConceptosAfipWizardData_Completado_N ;
   }

   public GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> getgxTv_SdtConceptosAfipWizardData_Auxiliardata( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Auxiliardata == null )
      {
         gxTv_SdtConceptosAfipWizardData_Auxiliardata = new GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "PayDay", remoteHandle);
      }
      gxTv_SdtConceptosAfipWizardData_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      return gxTv_SdtConceptosAfipWizardData_Auxiliardata ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Auxiliardata( GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> value )
   {
      gxTv_SdtConceptosAfipWizardData_Auxiliardata_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(0) ;
      gxTv_SdtConceptosAfipWizardData_Auxiliardata = value ;
   }

   public void setgxTv_SdtConceptosAfipWizardData_Auxiliardata_SetNull( )
   {
      gxTv_SdtConceptosAfipWizardData_Auxiliardata_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Auxiliardata = null ;
   }

   public boolean getgxTv_SdtConceptosAfipWizardData_Auxiliardata_IsNull( )
   {
      if ( gxTv_SdtConceptosAfipWizardData_Auxiliardata == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtConceptosAfipWizardData_Auxiliardata_N( )
   {
      return gxTv_SdtConceptosAfipWizardData_Auxiliardata_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConceptosAfipWizardData_Concepto1_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Completado_N = (byte)(1) ;
      gxTv_SdtConceptosAfipWizardData_Auxiliardata_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConceptosAfipWizardData_N ;
   }

   public web.SdtConceptosAfipWizardData Clone( )
   {
      return (web.SdtConceptosAfipWizardData)(clone()) ;
   }

   public void setStruct( web.StructSdtConceptosAfipWizardData struct )
   {
      setgxTv_SdtConceptosAfipWizardData_Concepto1(new web.SdtConceptosAfipWizardData_Concepto1(struct.getConcepto1()));
      setgxTv_SdtConceptosAfipWizardData_Completado(new web.SdtConceptosAfipWizardData_Completado(struct.getCompletado()));
      GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux = new GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem>(web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem.class, "WizardAuxiliarDataItem", "PayDay", remoteHandle);
      Vector<web.wwpbaseobjects.StructSdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux1 = struct.getAuxiliardata();
      if (gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux1.size(); i++)
         {
            gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux.add(new web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem(gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtConceptosAfipWizardData_Auxiliardata(gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConceptosAfipWizardData getStruct( )
   {
      web.StructSdtConceptosAfipWizardData struct = new web.StructSdtConceptosAfipWizardData ();
      struct.setConcepto1(getgxTv_SdtConceptosAfipWizardData_Concepto1().getStruct());
      struct.setCompletado(getgxTv_SdtConceptosAfipWizardData_Completado().getStruct());
      struct.setAuxiliardata(getgxTv_SdtConceptosAfipWizardData_Auxiliardata().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtConceptosAfipWizardData_Concepto1_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_Completado_N ;
   protected byte gxTv_SdtConceptosAfipWizardData_Auxiliardata_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtConceptosAfipWizardData_Auxiliardata_aux ;
   protected GXBaseCollection<web.wwpbaseobjects.SdtWizardAuxiliarData_WizardAuxiliarDataItem> gxTv_SdtConceptosAfipWizardData_Auxiliardata=null ;
   protected web.SdtConceptosAfipWizardData_Concepto1 gxTv_SdtConceptosAfipWizardData_Concepto1=null ;
   protected web.SdtConceptosAfipWizardData_Completado gxTv_SdtConceptosAfipWizardData_Completado=null ;
}

