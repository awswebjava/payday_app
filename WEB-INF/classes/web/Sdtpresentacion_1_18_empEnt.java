package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpresentacion_1_18_empEnt extends GxUserType
{
   public Sdtpresentacion_1_18_empEnt( )
   {
      this(  new ModelContext(Sdtpresentacion_1_18_empEnt.class));
   }

   public Sdtpresentacion_1_18_empEnt( ModelContext context )
   {
      super( context, "Sdtpresentacion_1_18_empEnt");
   }

   public Sdtpresentacion_1_18_empEnt( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "Sdtpresentacion_1_18_empEnt");
   }

   public Sdtpresentacion_1_18_empEnt( StructSdtpresentacion_1_18_empEnt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "cuit") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_Cuit = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "denominacion") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_Sdtpresentacion_1_18_empEnt_Denominacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ingresosAportes") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes == null )
               {
                  gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp>(web.Sdtpresentacion_1_18_empEnt_ingAp.class, "presentacion_1_18.empEnt.ingAp", "", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes.readxmlcollection(oReader, "ingresosAportes", "ingAp") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "ingresosAportes") )
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
         sName = "presentacion_1_18.empEnt" ;
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
      oWriter.writeElement("cuit", GXutil.trim( GXutil.str( gxTv_Sdtpresentacion_1_18_empEnt_Cuit, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("denominacion", gxTv_Sdtpresentacion_1_18_empEnt_Denominacion);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes.writexmlcollection(oWriter, "ingresosAportes", sNameSpace1, "ingAp", "");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
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
      AddObjectProperty("cuit", gxTv_Sdtpresentacion_1_18_empEnt_Cuit, false, false);
      AddObjectProperty("denominacion", gxTv_Sdtpresentacion_1_18_empEnt_Denominacion, false, false);
      if ( gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes != null )
      {
         AddObjectProperty("ingresosAportes", gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes, false, false);
      }
   }

   public long getgxTv_Sdtpresentacion_1_18_empEnt_Cuit( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_Cuit ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_Cuit( long value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Cuit = value ;
   }

   public String getgxTv_Sdtpresentacion_1_18_empEnt_Denominacion( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_Denominacion ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_Denominacion( String value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Denominacion = value ;
   }

   public GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp> getgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes( )
   {
      if ( gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes == null )
      {
         gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp>(web.Sdtpresentacion_1_18_empEnt_ingAp.class, "presentacion_1_18.empEnt.ingAp", "", remoteHandle);
      }
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      return gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes( GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp> value )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(0) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes = value ;
   }

   public void setgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_SetNull( )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes = null ;
   }

   public boolean getgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_IsNull( )
   {
      if ( gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpresentacion_1_18_empEnt_N = (byte)(1) ;
      gxTv_Sdtpresentacion_1_18_empEnt_Denominacion = "" ;
      gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpresentacion_1_18_empEnt_N ;
   }

   public web.Sdtpresentacion_1_18_empEnt Clone( )
   {
      return (web.Sdtpresentacion_1_18_empEnt)(clone()) ;
   }

   public void setStruct( web.StructSdtpresentacion_1_18_empEnt struct )
   {
      setgxTv_Sdtpresentacion_1_18_empEnt_Cuit(struct.getCuit());
      setgxTv_Sdtpresentacion_1_18_empEnt_Denominacion(struct.getDenominacion());
      GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp> gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux = new GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp>(web.Sdtpresentacion_1_18_empEnt_ingAp.class, "presentacion_1_18.empEnt.ingAp", "", remoteHandle);
      Vector<web.StructSdtpresentacion_1_18_empEnt_ingAp> gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux1 = struct.getIngresosaportes();
      if (gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux1.size(); i++)
         {
            gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux.add(new web.Sdtpresentacion_1_18_empEnt_ingAp(gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes(gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpresentacion_1_18_empEnt getStruct( )
   {
      web.StructSdtpresentacion_1_18_empEnt struct = new web.StructSdtpresentacion_1_18_empEnt ();
      struct.setCuit(getgxTv_Sdtpresentacion_1_18_empEnt_Cuit());
      struct.setDenominacion(getgxTv_Sdtpresentacion_1_18_empEnt_Denominacion());
      struct.setIngresosaportes(getgxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtpresentacion_1_18_empEnt_N ;
   protected byte gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected long gxTv_Sdtpresentacion_1_18_empEnt_Cuit ;
   protected String gxTv_Sdtpresentacion_1_18_empEnt_Denominacion ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp> gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes_aux ;
   protected GXBaseCollection<web.Sdtpresentacion_1_18_empEnt_ingAp> gxTv_Sdtpresentacion_1_18_empEnt_Ingresosaportes=null ;
}

