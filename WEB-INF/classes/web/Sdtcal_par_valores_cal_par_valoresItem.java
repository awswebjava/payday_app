package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtcal_par_valores_cal_par_valoresItem extends GxUserType
{
   public Sdtcal_par_valores_cal_par_valoresItem( )
   {
      this(  new ModelContext(Sdtcal_par_valores_cal_par_valoresItem.class));
   }

   public Sdtcal_par_valores_cal_par_valoresItem( ModelContext context )
   {
      super( context, "Sdtcal_par_valores_cal_par_valoresItem");
   }

   public Sdtcal_par_valores_cal_par_valoresItem( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtcal_par_valores_cal_par_valoresItem");
   }

   public Sdtcal_par_valores_cal_par_valoresItem( StructSdtcal_par_valores_cal_par_valoresItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParId") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "value") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParCampo") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParValLista") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParGrp") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParGrpDep") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParObl") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParDef") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CalParNombre") )
            {
               gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "cal_par_valores.cal_par_valoresItem" ;
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
      oWriter.writeElement("CalParId", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("value", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParCampo", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParValLista", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParGrp", GXutil.trim( GXutil.str( gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParGrpDep", GXutil.trim( GXutil.str( gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParObl", GXutil.booltostr( gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParDef", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CalParNombre", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("CalParId", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid, false, false);
      AddObjectProperty("value", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value, false, false);
      AddObjectProperty("CalParCampo", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo, false, false);
      AddObjectProperty("CalParValLista", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista, false, false);
      AddObjectProperty("CalParGrp", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp, false, false);
      AddObjectProperty("CalParGrpDep", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep, false, false);
      AddObjectProperty("CalParObl", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl, false, false);
      AddObjectProperty("CalParDef", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef, false, false);
      AddObjectProperty("CalParNombre", gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre, false, false);
   }

   public String getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid = value ;
   }

   public String getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value = value ;
   }

   public String getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo = value ;
   }

   public String getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista = value ;
   }

   public byte getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp( byte value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp = value ;
   }

   public byte getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep( byte value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep = value ;
   }

   public boolean getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl( boolean value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl = value ;
   }

   public String getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef = value ;
   }

   public String getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre ;
   }

   public void setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre( String value )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(0) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_N = (byte)(1) ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef = "" ;
      gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtcal_par_valores_cal_par_valoresItem_N ;
   }

   public web.Sdtcal_par_valores_cal_par_valoresItem Clone( )
   {
      return (web.Sdtcal_par_valores_cal_par_valoresItem)(clone()) ;
   }

   public void setStruct( web.StructSdtcal_par_valores_cal_par_valoresItem struct )
   {
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid(struct.getCalparid());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value(struct.getValue());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo(struct.getCalparcampo());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista(struct.getCalparvallista());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp(struct.getCalpargrp());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep(struct.getCalpargrpdep());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl(struct.getCalparobl());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef(struct.getCalpardef());
      setgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre(struct.getCalparnombre());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtcal_par_valores_cal_par_valoresItem getStruct( )
   {
      web.StructSdtcal_par_valores_cal_par_valoresItem struct = new web.StructSdtcal_par_valores_cal_par_valoresItem ();
      struct.setCalparid(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid());
      struct.setValue(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value());
      struct.setCalparcampo(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo());
      struct.setCalparvallista(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista());
      struct.setCalpargrp(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp());
      struct.setCalpargrpdep(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep());
      struct.setCalparobl(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl());
      struct.setCalpardef(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef());
      struct.setCalparnombre(getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre());
      return struct ;
   }

   protected byte gxTv_Sdtcal_par_valores_cal_par_valoresItem_N ;
   protected byte gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrp ;
   protected byte gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpargrpdep ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Value ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calpardef ;
   protected String sTagName ;
   protected boolean gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparobl ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparcampo ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparvallista ;
   protected String gxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparnombre ;
}

