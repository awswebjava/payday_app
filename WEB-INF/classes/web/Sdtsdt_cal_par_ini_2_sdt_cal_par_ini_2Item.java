package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item extends GxUserType
{
   public Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item( )
   {
      this(  new ModelContext(Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item.class));
   }

   public Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item( ModelContext context )
   {
      super( context, "Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item");
   }

   public Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item");
   }

   public Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item( StructSdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "idOperando") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "id") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "validation") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "formula") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "example") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "example_explanation") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "mandatory") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "group") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "default") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "group_dependency") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "description") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiCod") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "name") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "valid_list") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detail") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "documentation") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "dummy") )
            {
               gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy = oReader.getValue() ;
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
         sName = "sdt_cal_par_ini_2.sdt_cal_par_ini_2Item" ;
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
      oWriter.writeElement("idOperando", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("id", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("validation", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("formula", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("example", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("example_explanation", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("mandatory", GXutil.booltostr( gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("group", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group, 10, 5)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("default", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("group_dependency", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("description", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiCod", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("name", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("valid_list", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("detail", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("documentation", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("dummy", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("idOperando", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando, false, false);
      AddObjectProperty("id", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id, false, false);
      AddObjectProperty("validation", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation, false, false);
      AddObjectProperty("formula", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula, false, false);
      AddObjectProperty("example", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example, false, false);
      AddObjectProperty("example_explanation", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation, false, false);
      AddObjectProperty("mandatory", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory, false, false);
      AddObjectProperty("group", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group, false, false);
      AddObjectProperty("default", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default, false, false);
      AddObjectProperty("group_dependency", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency, false, false);
      AddObjectProperty("description", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description, false, false);
      AddObjectProperty("PaiCod", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod, false, false);
      AddObjectProperty("name", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name, false, false);
      AddObjectProperty("valid_list", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list, false, false);
      AddObjectProperty("detail", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail, false, false);
      AddObjectProperty("documentation", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation, false, false);
      AddObjectProperty("dummy", gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy, false, false);
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation = value ;
   }

   public boolean getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory( boolean value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation = value ;
   }

   public String getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy ;
   }

   public void setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy( String value )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(0) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N = (byte)(1) ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation = "" ;
      gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N ;
   }

   public web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item Clone( )
   {
      return (web.Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item struct )
   {
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando(struct.getIdoperando());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id(struct.getId());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation(struct.getValidation());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula(struct.getFormula());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example(struct.getExample());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation(struct.getExample_explanation());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory(struct.getMandatory());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group(struct.getGroup());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default(struct.getDefault());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency(struct.getGroup_dependency());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description(struct.getDescription());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod(struct.getPaicod());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name(struct.getName());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list(struct.getValid_list());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail(struct.getDetail());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation(struct.getDocumentation());
      setgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy(struct.getDummy());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item getStruct( )
   {
      web.StructSdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item struct = new web.StructSdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item ();
      struct.setIdoperando(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando());
      struct.setId(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id());
      struct.setValidation(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation());
      struct.setFormula(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula());
      struct.setExample(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example());
      struct.setExample_explanation(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation());
      struct.setMandatory(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory());
      struct.setGroup(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group());
      struct.setDefault(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default());
      struct.setGroup_dependency(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency());
      struct.setDescription(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description());
      struct.setPaicod(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod());
      struct.setName(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name());
      struct.setValid_list(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list());
      struct.setDetail(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail());
      struct.setDocumentation(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation());
      struct.setDummy(getgxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Mandatory ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Idoperando ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Id ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Validation ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Formula ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Example_explanation ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Default ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Group_dependency ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Description ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Paicod ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Name ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Valid_list ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Detail ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Documentation ;
   protected String gxTv_Sdtsdt_cal_par_ini_2_sdt_cal_par_ini_2Item_Dummy ;
}

